package com.river.service;

import java.util.List;
import java.util.Map;

import com.river.entity.Cartitem;


public interface CartitemService {
	
	/**
	 * 通过用户Id和商品Id查询数据库是否有车 
	 * @param map 用户Id：userId  商品Id：snacksId
	 * @return
	 */
	Cartitem findCaritemtBySnacksIdAndUserId(Map<String, Object> map);
	
	/**
	 * 更新车的一项
	 * @param userCart
	 */
	public abstract void updateCartitem(Cartitem cartitem);
	
	/**
	 * 添加一订单项到车
	 * @param userCart
	 */
	public abstract void addToCartitem(Cartitem cartitem);
	
	/**
	 * 查询当前用户的订单项
	 * @param userId
	 * @return
	 */
	List<Cartitem> findCartitemListByUserId(String userId);
	
	
	/**
	 * 删除购物车的某一个订单项
	 * @param cartitemId
	 */
	public abstract void deleteCartitem(String cartitemId);
	
	/**
	 * 清空购物车
	 */
	void clearCart(String userId);

}
