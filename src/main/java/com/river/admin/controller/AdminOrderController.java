package com.river.admin.controller;

import com.river.entity.Order;
import com.river.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

	@Resource
	OrderService orderService;
	
	@RequestMapping("/adminFindAllOrder")
	public String adminFindAllOrder(HttpServletRequest request) {
		
		List<Order> orderList = orderService.adminFindAllOrder();
		request.setAttribute("orderList", orderList);
		return "../adminjsps/admin/order/list.jsp";
	}
	
	
	@RequestMapping("/addminFindOrderByState")
	public String addminFindOrderByState(HttpServletRequest request) {
		
		List<Order> orderList = orderService.addminFindOrderByState(request.getParameter("state"));
		request.setAttribute("orderList", orderList);
		
		return "../adminjsps/admin/order/list.jsp";
	}
	
	@RequestMapping("/changeOrderState")
	public String changeOrderState(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderId", request.getParameter("orderId"));
		map.put("state",Integer.valueOf(request.getParameter("state")));
		orderService.changeOrderState(map);
		
		return "../adminjsps/admin/order/list.jsp";
	}
}
