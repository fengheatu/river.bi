package com.river.service.impl;

import com.river.dao.OrderDao;
import com.river.entity.Order;
import com.river.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource
	OrderDao orderDao;

	@Override
	public List<Order> findOrderByUserId(String userId) {
		
		return orderDao.findAllOrderByUserId(userId);
	}

	@Override
	public void addOrder(Order order) {
		
		orderDao.addOrder(order);
	}

	@Override
	public void updateOrder(Map<String, Object> map) {
		orderDao.updateOrder(map);
		
	}

	@Override
	public Order findByOrderId(String orderId) {
		
		return orderDao.findByOrderId(orderId);
	}

	@Override
	public void updateOrderState(Map<String, Object> map) {
	
		orderDao.updateOrderState(map);
	}

	@Override
	public List<Order> findOrderByUserIdWithState(Map<String, Object> map) {
		
		return orderDao.findOrderByUserIdWithState(map);
	}

	@Override
	public List<Order> adminFindAllOrder() {
		
		return orderDao.adminFindAllOrder();
	}

	@Override
	public List<Order> addminFindOrderByState(String state) {
		
		return orderDao.addminFindOrderByState(state);
	}



	@Override
	public void changeOrderState(Map<String, Object> map) {
	
		orderDao.changeOrderState(map);
		
	}


	
		
	

}
