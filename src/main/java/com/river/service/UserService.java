package com.river.service;

import com.river.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

	public abstract User login(User user);
	 
	 public abstract void regist(User user);
	 
	 /**
	  * 注册前检查手机号码是否被注册过
	  * @param phone 要校验的手机号码
	  * @return 返回一个字符串，没有被注册过返回null 已经注册过的返回该值
	  */
	 public abstract String checkUserForRegist(String phone);
	 
	 
	 /**
	  * 通过手机号码获取绑定的邮箱用来找回密码
	  * @param phone
	  * @return
	  */
	 public abstract String findEmailByPhone(String phone);
	 
	 
	/**
	 * 修改密码
	 * @param user
	 */
	public abstract void changePassword(User user);

	/**
	 * 查询所有用户
	 * @return
     */
	List<User> findAllUser();

	/**
	 * 通过手机号码查询用户信息
	 * @param phone
	 * @return
     */
	List<User> findByPhone(String phone);


	/**
	 * 通过用户Id查询用户信息
	 * @param userId
	 * @return
     */
	User  findUserByUserId(String userId);


	/**
	 * 更新用户信息
	 * @param user
	 * @return
     */

	int updateUserInfo(User user);
}
