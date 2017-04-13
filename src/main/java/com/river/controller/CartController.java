package com.river.controller;

import com.river.entity.Cartitem;
import com.river.entity.Snacks;
import com.river.entity.User;
import com.river.service.CartitemService;
import com.river.service.SnacksService;
import com.river.utils.CreateUUID;
import com.river.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Resource
	CartitemService cartitemService;
	
	@Resource
	SnacksService snacksService;
	
	@RequestMapping("/addToCart")
	public void addToCart(HttpServletRequest request,HttpServletResponse response) {
		
		User user = (User) request.getSession().getAttribute("user");
		logger.info("用户【" + user.getUserId() + "】使用购物车");
		if(user == null) {
			throw new RuntimeException("用户未登录");
		}else {
			int count = Integer.valueOf(request.getParameter("amount"));
			//通过snacksId和userId 查询看看数据数据库是否有用户的车
			String snacksId = request.getParameter("snacksId");
			Snacks snacks =snacksService.findById(snacksId);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("snacksId",snacksId);
			Cartitem cartitem = cartitemService.findCaritemtBySnacksIdAndUserId(map);
			if (cartitem != null) {
				cartitem.setUser(user);
				cartitem.setSnacks(snacks);
				cartitem.setSubtotal(snacks.getPrice() *(cartitem.getAmount() + count));
				cartitem.setAmount(cartitem.getAmount() + count);
				cartitemService.updateCartitem(cartitem);
			}else {
				cartitem = new Cartitem();
				cartitem.setCartitemId(CreateUUID.uuid());
				cartitem.setSnacks(snacks);
				cartitem.setAmount(1);
				cartitem.setUser(user);
				cartitem.setSubtotal(snacks.getPrice());
				cartitemService.addToCartitem(cartitem);
			}
			
			List<Cartitem> cartitemList = cartitemService.findCartitemListByUserId(user.getUserId());
			request.getSession().setAttribute("cartitemList", cartitemList);
			int _count = 0;
			for(Cartitem _cartitem : cartitemList) {
				
				_count += _cartitem.getAmount();
			}
			ResponseUtil.write(response, _count);
		}
	}
	
	@RequestMapping("/addSnacks")
	public String addSnacks(HttpServletRequest request,HttpServletResponse response) {
		updateCartitem(request, 1,1);
		return "userjsps/userdojsp/cart/list.jsp";
	}
	
	@RequestMapping("/reduceSnacks")
	public String reduceSnacks(HttpServletRequest request,HttpServletResponse response) {
		updateCartitem(request, -1,1);
		return "userjsps/userdojsp/cart/list.jsp";
	}
	
	@RequestMapping("/changAmount")
	public void changAmount(HttpServletRequest request) {
		updateCartitem(request,Integer.valueOf(request.getParameter("amount")), 0);
	}
	
	/**
	 * 更改数据库的中购物车表单项的数量的代码复用
	 * @param request
	 * @param amount
	 * @param style 为0时表示从页面中直接输入数量 为1时表示点击按钮添加1或减少1
	 */
	private void updateCartitem(HttpServletRequest request,int amount,int style) {
		User user = (User) request.getSession().getAttribute("user");
		String snacksId = request.getParameter("snacksId");

		logger.info("用户【"+ user.getUserId() + "】将商品【" + snacksId +"】加入购物车");

		Snacks snacks =snacksService.findById(snacksId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("snacksId",snacksId);
		Cartitem cartitem = cartitemService.findCaritemtBySnacksIdAndUserId(map);
		cartitem.setUser(user);
		cartitem.setSnacks(snacks);
		cartitem.setSubtotal(snacks.getPrice() *(cartitem.getAmount() + amount));
		int _amount1 = 0;
		cartitem.setAmount((_amount1 = style==1?cartitem.getAmount():0) + amount);
		cartitemService.updateCartitem(cartitem);
		List<Cartitem> cartitemList = cartitemService.findCartitemListByUserId(user.getUserId());
		request.getSession().setAttribute("cartitemList", cartitemList);
	}
	
	@RequestMapping("/deleteCartitem")
	public String deleteCartitem(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String cartitemId = request.getParameter("cartitemId");
		logger.info("用户【"+ user.getUserId() + "】从购物车中移除商品【" + cartitemId +"】");
		cartitemService.deleteCartitem(cartitemId);
		List<Cartitem> cartitemList = cartitemService.findCartitemListByUserId(user.getUserId());
		request.getSession().setAttribute("cartitemList", cartitemList);
		return "userjsps/userdojsp/cart/list.jsp";
	}
	
	
	
	
}
