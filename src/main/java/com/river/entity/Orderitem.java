package com.river.entity;

import java.io.Serializable;

public class Orderitem implements Serializable{
	
	private static final long serialVersionUID = -1915071198989562207L;
	private String orderitemId;
	private int count;
	private double subtotal;
	private Order order;
	private Snacks snacks;
	
	public Orderitem() {
		
	}

	public String getOrderitemId() {
		return orderitemId;
	}

	public void setOrderitemId(String orderitemId) {
		this.orderitemId = orderitemId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Snacks getSnacks() {
		return snacks;
	}

	public void setSnacks(Snacks snacks) {
		this.snacks = snacks;
	}

	
}
