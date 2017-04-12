package com.river.service.impl;

import com.river.dao.AddressDao;
import com.river.entity.Address;
import com.river.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Resource
	AddressDao addressDao;

	@Override
	public void addAddress(Address address) {
		
		addressDao.addAddress(address);
	}

	@Override
	public List<Address> findAddressByUserId(String userId) {
		
		return addressDao.findAddressByUserId(userId);
	}

	@Override
	public Object findByAddressId(String addressId) {
		
		return addressDao.findByAddressId(addressId);
	}

	@Override
	public void updateAddress(Address address) {
		
		addressDao.updateAddress(address);
	}

	@Override
	public void deleteAddressByAddressId(String addressId) {
		
		addressDao.deleteAddressByAddressId(addressId);
	}

	
}
