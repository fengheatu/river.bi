package com.river.admin.controller;

import com.river.admin.entity.AdminUser;
import com.river.dao.AdminUserDao;
import com.river.entity.User;
import com.river.service.UserService;
import com.river.utils.MD5Util;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AdminUserController.class);

	@Resource
	AdminUserDao adminUserDao;

	@Resource
	UserService userService;


	/**
	 *管理员登陆
	 * @param request
	 * @param adminUser
	 * @return
     */
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest request,AdminUser adminUser) {
		
		AdminUser admin =  adminUserDao.adminLogin(adminUser);

		logger.info("管理员【" + admin.getAdminUsername() + "】登陆");

		if(admin == null) {
			request.setAttribute("adminMsg", "管理员名称或密码有误");
			return "../adminjsps/login.jsp";
		}
		request.getSession().setAttribute("admin", admin);
	
		return "../adminjsps/admin/index.jsp";
	}

	@RequestMapping(value = "/adminLogout",method = RequestMethod.GET)
	public String adminLogout(HttpSession session) {
		AdminUser adminUser = (AdminUser) session.getAttribute("admin");
		logger.info("管理员【" + adminUser.getAdminUsername() + "】退出");
		session.removeAttribute("admin");
		return "redirect:../adminjsps/login.jsp";
	}

	/**
	 * 查询所有用户
	 * @param request
	 * @return
     */
	@RequestMapping("findAllUser")
	public String findAllUser(HttpServletRequest request) {

		logger.info("后台查询所有用户信息");
		request.setAttribute("userList",userService.findAllUser());

		return "../adminjsps/admin/user/list.jsp";
	}

	/**
	 * 通过手机号码查询用户
	 * @param phone
	 * @param request
     * @return
     */
	@RequestMapping(value = "/findByPhone",method = RequestMethod.POST)
	public String findByPhone(String phone,HttpServletRequest request){

		logger.info("后台查询【" + phone + " 】用户信息");

		request.setAttribute("userList",userService.findByPhone(phone));

		return "../adminjsps/admin/user/list.jsp";
	}

	/**
	 * 根据用户id查询用户信息
	 * @param userId
	 * @param request
     * @return
     */
	@RequestMapping("/findUserByUserId")
	public String findUserByUserId(String userId,HttpServletRequest request){

		logger.info("后台查询【" + userId + " 】用户信息");

		request.setAttribute("user",userService.findUserByUserId(userId));

		return "../adminjsps/admin/user/update.jsp";
	}

	/**
	 * 更新用户信息
	 * @param user
	 * @param request
     * @return
     */
	@RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
	public String updateUserInfo(User user, HttpServletRequest request) {
		if(!StringUtils.isEmpty(user.getPassword())) {
			user.setPassword(MD5Util.MD5(user.getPassword()));
		}else{
			user.setPassword(null);
		}
		int result = userService.updateUserInfo(user);
		if(result == 1){
			request.setAttribute("msg","更新成功");
		}else {
			request.setAttribute("msg","更新失败");
		}

		return "../adminjsps/admin/user/update.jsp";
	}
}
