package com.river.entity;

import java.io.Serializable;

public class Cartitem implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6053717082457092308L;
	private String cartitemId;
	private int amount;
	public double subtotal;
	private Snacks snacks;
	private User user;

	public String getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(String cartitemId) {
		this.cartitemId = cartitemId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Snacks getSnacks() {
		return snacks;
	}

	public void setSnacks(Snacks snacks) {
		this.snacks = snacks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getSubtotal() {
		return subtotal;
	}

	@Override
	public String toString() {
		return "Cartitem [cartitemId=" + cartitemId + ", amount=" + amount
				+ ", subtotal=" + subtotal + ", snacks=" + snacks + ", user="
				+ user + "]";
	}
	
	
}
