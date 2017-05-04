package com.river.controller;

import com.river.entity.*;
import com.river.service.*;
import com.river.utils.CreateUUID;
import com.river.utils.PaymentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Resource
	OrderService orderService;

	@Resource
	CartitemService cartitemService;

	@Resource
	OrderitemService orderitemService;

	@Resource
	AddressService addressService;
	
	@Resource
	SnacksService snacksService;

	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request,
			HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");

		logger.info("用户【" + user.getUserId() + "】添加订单");

		List<Cartitem> cartitemList = cartitemService
				.findCartitemListByUserId(user.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		map.put("state", 1);
		if (cartitemList.size() > 0) {
			Order order = new Order();
			order.setOrderId(CreateUUID.uuid());
			order.setOrdertime(new Date());
			order.setState(1);
			order.setUser(user);
			order.setAddress(new Address());
			orderService.addOrder(order);

			for (Cartitem cartitem : cartitemList) {
				Orderitem orderitem = new Orderitem();
				orderitem.setOrderitemId(CreateUUID.uuid());
				orderitem.setSnacks(cartitem.getSnacks());
				orderitem.setCount(cartitem.getAmount());
				orderitem.setSubtotal(cartitem.getSubtotal());
				orderitem.setOrder(order);
				orderitemService.addOrderitem(orderitem);
				order.getOrderitemList().add(orderitem);
			}

			cartitemService.clearCart(user.getUserId());
			request.getSession().removeAttribute("cartitemList");

			List<Order> orderList = orderService.findOrderByUserIdWithState(map);
			request.getSession().setAttribute("orderList", orderList);
			List<Address> addressList = addressService.findAddressByUserId(user
					.getUserId());
			request.setAttribute("addressList", addressList);
			return "userjsps/userdojsp/order/order.jsp";
		} else {
			List<Order> orderList = orderService.findOrderByUserIdWithState(map);
			request.getSession().setAttribute("orderList", orderList);
			List<Address> addressList = addressService.findAddressByUserId(user
					.getUserId());
			request.setAttribute("addressList", addressList);
			return "userjsps/userdojsp/order/order.jsp";
		}

	}

	@RequestMapping("/commitorder")
	public String commitorder(HttpServletRequest request) {

		String orderId = request.getParameter("orderId");
		String addressId = request.getParameter("addressId");
		String totalprice = request.getParameter("totalprice");

		logger.info("用户提交订单【" + orderId + "】");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("addressId", addressId);

		orderService.updateOrder(map);
		request.setAttribute("totalprice", totalprice);
		Order order = orderService.findByOrderId(orderId);
		request.setAttribute("order", order);
		return "userjsps/userdojsp/order/pay.jsp";
	}

	@RequestMapping("/payToBank")
	public String payToBank(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("付款");

		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("merchantInfo.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String p0_Cmd = "Buy";
		String p1_MerId = prop.getProperty("p1_MerId");
		String p2_Order = request.getParameter("orderId");
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = prop.getProperty("p8_Url");
		String p9_SAF = "";
		String pa_MP = "";
		String pd_FrpId = request.getParameter("pd_FrpId");
		String pr_NeedResponse = "1";

		String keyValue = prop.getProperty("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		
		StringBuffer url = new StringBuffer(prop.getProperty("url"));
		url.append("?p0_Cmd").append(p0_Cmd);
		url.append("&p1_MerId").append(p1_MerId);
		url.append("&p2_Order").append(p2_Order);
		url.append("&p3_Amt").append(p3_Amt);
		url.append("&p4_Cur").append(p4_Cur);
		url.append("&p5_Pid").append(p5_Pid);
		url.append("&p6_Pcat").append(p6_Pcat);
		url.append("&p7_Pdesc").append(p7_Pdesc);
		url.append("&p8_Url").append(p8_Url);
		url.append("&p9_SAF").append(p9_SAF);
		url.append("&pa_MP").append(pa_MP);
		url.append("&pd_FrpId").append(pd_FrpId);
		url.append("&pr_NeedResponse").append(pr_NeedResponse);
		url.append("&hmac").append(hmac);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId",request.getParameter("orderId"));
		map.put("state",2);
		orderService.updateOrderState(map);
		try {
			response.sendRedirect(url.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@RequestMapping("/findOrderByUserIdWithState")
	public String findOrderByUserIdWithState(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		logger.info("根据状态【"+ request.getParameter("state") +"】查询用户【" + user.getUserId() + "】订单");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		map.put("state", Integer.valueOf(request.getParameter("state")));
		List<Order> orderList = orderService.findOrderByUserIdWithState(map);
		request.getSession().setAttribute("orderList", orderList);
		return "userjsps/userdojsp/order/list.jsp";
	}
	
	@RequestMapping("/findOrderByUserId")
	public String findOrderByUserId(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		logger.info("查询用户【" + user.getUserId() +"】所有订单");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		map.put("state", 1);
		List<Order> orderList = orderService.findOrderByUserId(user.getUserId());
		request.getSession().setAttribute("orderList", orderList);
		
		return "userjsps/userdojsp/order/list.jsp";
	}
	
	@RequestMapping("/payOneOrder")
	public String payOneOrder(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Order order = orderService.findByOrderId(request.getParameter("orderId"));

		logger.info("用户【" + user.getUserId() + "】付款订单【"+ request.getParameter("orderId") + "】 ");

		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		request.getSession().setAttribute("orderList", orderList);
		List<Address> addressList = addressService.findAddressByUserId(user
				.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp"; 
	}
	
	@RequestMapping("/updateOrderState")
	public String updateOrderState(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		logger.info("用户【" + user.getUserId()+ "】修改订单【" + request.getParameter("orderId") +"】状态【" +request.getParameter("state") +" 】");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId",request.getParameter("orderId"));
		map.put("state",Integer.valueOf(request.getParameter("state")));
		orderService.updateOrderState(map);
		List<Order> orderList = orderService.findOrderByUserId(user.getUserId());
		request.getSession().setAttribute("orderList", orderList);
		return "userjsps/userdojsp/order/list.jsp";
	}
	
	
	@RequestMapping("/addOrdertByeCount")
	public String addToCartByeCount(HttpServletRequest request,HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if(user== null) {
			try {
				response.sendRedirect("userjsps/loginregist.jsp");
			} catch (IOException e) {
				throw  new RuntimeException(e);
			}
			return null;
		}else {
		Snacks snacks =snacksService.findById(request.getParameter("snacksId"));
		logger.info("添加商品【" + snacks.getSnacksId() + "】订单");
		Order order = new Order();
		order.setOrderId(CreateUUID.uuid());
		order.setOrdertime(new Date());
		order.setState(1);
		order.setUser(user);
		order.setAddress(new Address());
		orderService.addOrder(order);
		
		int amount = Integer.valueOf(request.getParameter("amount"));
		Orderitem orderitem = new Orderitem();
		orderitem.setOrderitemId(CreateUUID.uuid());
		orderitem.setSnacks(snacks);
		orderitem.setCount(amount);
		orderitem.setSubtotal(amount * amount);
		orderitem.setOrder(order);
		orderitemService.addOrderitem(orderitem);
		order.getOrderitemList().add(orderitem);
		
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		request.getSession().setAttribute("orderList", orderList);
		return "userjsps/userdojsp/order/order.jsp";
		}
	}

	/**
	 * 删除用户订单
	 * @param orderId
	 * @param request
     * @return
     */
	@RequestMapping(value = "deleteOneOrder",method= RequestMethod.GET)
	public String deleteOneOrder(String orderId,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		orderService.deleteOneOrderByOefer(orderId);

		logger.info("用户【" + user.getUserId() + "】删除订单【" + orderId +"】");

		request.getSession().setAttribute("orderList", orderService.findOrderByUserId(user.getUserId()));
		return "userjsps/userdojsp/order/list.jsp";
	}

	/**
	 * 删除用户订单
	 * @param orderId
	 * @param request
     * @return
     */
	@RequestMapping(value = "realDeleteOneOrder",method= RequestMethod.GET)
	public String realDeleteOneOrder(String orderId,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		orderService.realDeleteOneOrder(orderId);

		logger.info("用户【" + user.getUserId() + "】删除订单【" + orderId +"】");

		request.getSession().setAttribute("orderList", orderService.findOrderByUserId(user.getUserId()));
		return "userjsps/userdojsp/order/list.jsp";
	}




}
