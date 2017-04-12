package com.river.service.impl;

import com.river.dao.UserDao;
import com.river.entity.User;
import com.river.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserDao userDao;
	
	
	@Override
	public User login(User user) {
	
		return userDao.login(user);
	}

	@Override
	public void regist(User user) {
		userDao.regist(user);

	}

	@Override
	public String checkUserForRegist(String phone) {
		
		return userDao.checkUserForRegist(phone);
	}

	@Override
	public String findEmailByPhone(String phone) {
		
		return userDao.findEmailByPhone(phone);
	}

	@Override
	public void changePassword(User user) {
		
		userDao.changePassword(user);
	}

}
