package com.river.service.impl;

import com.river.dao.UserDao;
import com.river.entity.User;
import com.river.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserDao userDao;
	
	
	@Override
	public User login(User user) {
	
		return userDao.login(user);
	}

	@Override
	@Transactional
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
	@Transactional
	public void changePassword(User user) {
		
		userDao.changePassword(user);
	}

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	/**
	 * 通过手机号码查询用户信息
	 *
	 * @param phone
	 * @return
	 */
	@Override
	public List<User> findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}


	/**
	 * 通过用户Id查询用户信息
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public User findUserByUserId(String userId) {
		return userDao.findUserByUserId(userId);
	}

	/**
	 * 更新用户信息
	 *
	 * @param user
	 * @return
	 */
	@Override
	@Transactional
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}
}
