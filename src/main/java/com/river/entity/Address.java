package com.river.entity;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = -4410264880827108406L;
	private String addressId;
	private String phone;
	private String address;
	private String zipcode;
	private User user;
	private String consignee;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", phone=" + phone
				+ ", address=" + address + ", zipcode=" + zipcode + ", user="
				+ user + ", consignee=" + consignee + "]";
	}
	
	
	
	
	
	
}
