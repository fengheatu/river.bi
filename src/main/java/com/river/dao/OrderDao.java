package com.river.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.river.entity.Order;

@Repository
public interface OrderDao {
		
	/**
	 * 通过用户Id全部订单
	 * @param userId 
	 * @param statu  1 未付款 2已付款3已发货4已完成
	 * @return
	 */
	public abstract List<Order> findAllOrderByUserId(String userId);
	
	
	/**
	 *添加一个订单
	 * @param order
	 */
	public abstract void addOrder(Order order);

	
	/**
	 * 更新订单的地址
	 * @param map
	 */
	public abstract void updateOrder(Map<String, Object> map);

	
	/**
	 * 通过Id查找订单信息
	 * @param orderId
	 * @return
	 */
	public abstract Order findByOrderId(String orderId);

	
	/**
	 * 修改订单状态
	 * @param map
	 */
	public abstract void updateOrderState(Map<String, Object> map);

	
	/**
	 * 通过用户名和订单状态查找全部订单
	 * @param userId 
	 * @param statu  1 未付款 2已付款3已发货4已完成
	 * @return
	 */
	public abstract List<Order> findOrderByUserIdWithState(
			Map<String, Object> map);

	
	/**
	 * 管理员查询所有的订单信息
	 * @return
	 */
	public abstract List<Order> adminFindAllOrder();


	/**
	 * 通过订单状态查找订单信息
	 * @param parameter
	 * @return
	 */
	public abstract List<Order> addminFindOrderByState(String state);

	
	/**
	 * 修改订单状态
	 * @param map
	 */
	public abstract void changeOrderState(Map<String, Object> map);


	

	
	
	
}
