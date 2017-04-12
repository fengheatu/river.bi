package com.river.service.impl;

import com.river.dao.CartitemDao;
import com.river.entity.Cartitem;
import com.river.service.CartitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CartitemServiceImpl implements CartitemService {
	
	@Resource
	CartitemDao cartitemDao;
	
	@Override
	public Cartitem findCaritemtBySnacksIdAndUserId(Map<String, Object> map) {
		
		
		return cartitemDao.findCaritemtBySnacksIdAndUserId(map);
	}

	@Override
	public void updateCartitem(Cartitem cartitem) {
		cartitemDao.updateCartitem(cartitem);
		
	}

	@Override
	public void addToCartitem(Cartitem cartitem) {
		
		cartitemDao.addToCartitem(cartitem);
	}

	@Override
	public List<Cartitem> findCartitemListByUserId(String userId) {
		
		return cartitemDao.findCartitemListByUserId(userId);
	}

	@Override
	public void deleteCartitem(String cartitemId) {

		cartitemDao.deleteCartitem(cartitemId);
	}

	@Override
	public void clearCart(String userId) {
	
		cartitemDao.clearCart(userId);
	}

}
