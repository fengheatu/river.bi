package com.river.service.impl;

import com.river.dao.OrderitemDao;
import com.river.entity.Orderitem;
import com.river.service.OrderitemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderitemServiceImpl implements OrderitemService {
	
	@Resource
	OrderitemDao orderitemDao;

	@Override
	@Transactional
	public void addOrderitem(Orderitem orderitem) {
		
		orderitemDao.addOrderitem(orderitem);
	}

	
	
	
	
}
