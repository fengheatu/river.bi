package com.river.service;

import java.util.List;
import java.util.Map;

import com.river.entity.Order;
import com.river.entity.Orderitem;

public interface OrderService {
	
	/**
	 * 通过用户名和订单状态查找全部订单
	 * @param userId 
	 * @param statu  1 未付款 2已付款3已发货4已完成
	 * @return
	 */
	public abstract List<Order> findOrderByUserIdWithState(Map<String, Object> map);
	
	/**
	 * 添加一个订单
	 * @param order
	 */
	public abstract void addOrder(Order order);
	
	
	/**
	 * 更新订单的地址信息
	 * @param map
	 */
	public abstract void updateOrder(Map<String, Object> map);
	
	/**
	 * 通过Id查找订单
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
	 * 通过用户Id来查询
	 * @param map
	 * @return
	 */
	public abstract List<Order> findOrderByUserId(
			String userId);
	
	
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
	 * @param valueOf
	 */
	public abstract void changeOrderState(Map<String, Object> map);

	/**
	 * 按条件查询订单
	 * @param phone
	 * @param orderId
     * @return
     */
	List<Order> findByPhoneWithOrderId(String phone, String orderId);

	/**
	 * 删除订单
	 * @param orderId
     */
	void deleteOneOrderByOefer(String orderId);


	/**
	 * 删除订单
	 * @param orderId
	 */
	void realDeleteOneOrder(String orderId);


	/**
	 * 获取订单收货信息
	 * @param orderId
	 * @return
	 */
	Order getShipmentsInfoByOrderId(String orderId);
}
