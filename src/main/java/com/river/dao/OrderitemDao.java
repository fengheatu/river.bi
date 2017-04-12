package com.river.dao;

import com.river.entity.Orderitem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderitemDao {

	/**
	 * 通过订单编号找订单项
	 * @param orderId
	 * @return
	 */
	public abstract List<Orderitem> findByOrderId(String orderId);
	
	/**
	 * 添加订单项
	 * @param orderitem
	 */
	public abstract void addOrderitem(Orderitem orderitem);

}
