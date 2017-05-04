package com.river.service.impl;

import com.river.dao.OrderDao;
import com.river.entity.Order;
import com.river.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void addOrder(Order order) {
		
		orderDao.addOrder(order);
	}

	@Override
	@Transactional
	public void updateOrder(Map<String, Object> map) {
		orderDao.updateOrder(map);
		
	}

	@Override
	public Order findByOrderId(String orderId) {
		
		return orderDao.findByOrderId(orderId);
	}

	@Override
	@Transactional
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
	@Transactional
	public void changeOrderState(Map<String, Object> map) {
	
		orderDao.changeOrderState(map);
		
	}


	/**
	 * 按条件查询订单
	 *
	 * @param phone
	 * @param orderId
	 * @return
	 */
	@Override
	public List<Order> findByPhoneWithOrderId(String phone, String orderId) {
		return orderDao.findByPhoneWithOrderId( phone,orderId);
	}

	/**
	 * 删除订单
	 *
	 * @param orderId
	 */
	@Override
	public void deleteOneOrderByOefer(String orderId) {
		orderDao.deleteOneOrderByOefer(orderId);
	}

	/**
	 * 删除订单
	 *
	 * @param orderId
	 */
	@Override
	public void realDeleteOneOrder(String orderId) {
		orderDao.realDeleteOneOrder(orderId);
	}


	/**
	 * 获取订单收货信息
	 *
	 * @param orderId
	 * @return
	 */
	@Override
	public Order getShipmentsInfoByOrderId(String orderId) {
		return orderDao.queryShipmentsInfoByOrderId(orderId);
	}
}
