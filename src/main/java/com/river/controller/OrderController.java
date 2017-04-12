package com.river.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.river.entity.Address;
import com.river.entity.Cartitem;
import com.river.entity.Order;
import com.river.entity.Orderitem;
import com.river.entity.Snacks;
import com.river.entity.User;
import com.river.service.AddressService;
import com.river.service.CartitemService;
import com.river.service.OrderService;
import com.river.service.OrderitemService;
import com.river.service.SnacksService;
import com.river.utils.CreateUUID;
import com.river.utils.PaymentUtil;

@Controller
public class OrderController {

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
}
