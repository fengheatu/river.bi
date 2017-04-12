package com.river.service;

import java.util.List;

import com.river.entity.Address;

import static com.oracle.jrockit.jfr.ContentType.Address;

public interface AddressService {
	
	/**
	 * 添加地址信息
	 * @param address
	 */
	public abstract void addAddress(Address address);
	
	/**
	 * 通过用户Id查询所有的用户地址
	 * @param userId
	 * @return
	 */
	public abstract List<Address> findAddressByUserId(String userId);
	
	
	/**
	 * 通过地址的Id查找相应的地址信息
	 * @param addressId
	 * @return
	 */
	public abstract Object findByAddressId(String addressId);
	
	
	/**
	 * 更新地址信息
	 * @param address
	 */
	public abstract void updateAddress(Address address);
	
	/**
	 * 通过Id删除地址信息
	 * @param parameter
	 */
	public abstract void deleteAddressByAddressId(String addressId);

	
}
