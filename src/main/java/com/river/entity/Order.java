package com.river.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 8757892428208425958L;
	private String orderId;
	private Date ordertime;
	private User user;
	private Address address;
	private List<com.river.entity.Orderitem> orderitemList = new ArrayList<com.river.entity.Orderitem>();
	private int state; //订单状态 1 未付款 2已付款3已发货4已完成
	private Integer isDelete;
	public Order() {
	
	}

	public Order(String orderId, Date ordertime, User user, Address address, List<Orderitem> orderitemList, int state, Integer isDelete) {
		this.orderId = orderId;
		this.ordertime = ordertime;
		this.user = user;
		this.address = address;
		this.orderitemList = orderitemList;
		this.state = state;
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<com.river.entity.Orderitem> getOrderitemList() {
		return orderitemList;
	}
	public void setOrderitemList(List<com.river.entity.Orderitem> orderitemList) {
		this.orderitemList = orderitemList;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ordertime=" + ordertime
				+ ", user=" + user + ", address=" + address
				+ ", orderitemList=" + orderitemList + ", state=" + state + "]";
	}
	
	
}
