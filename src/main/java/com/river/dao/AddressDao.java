package com.river.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.river.entity.Address;

import static com.oracle.jrockit.jfr.ContentType.Address;

@Repository
public interface AddressDao {

	/**
	 * 添加地址信息
	 * @param address
	 */
	public abstract void addAddress(Address address);
	
	
	/**
	 * 通过用户Id查询用户所有地址
	 * @param userId
	 * @return
	 */
	public abstract List<Address> findAddressByUserId(String userId);

	/**
	 * 通过地址Id查找相应的地址信息
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
	 * @param addressId
	 */
	public abstract void deleteAddressByAddressId(String addressId);
	
	
}
