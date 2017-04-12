package com.river.admin.controller;

import com.river.admin.entity.AdminUser;
import com.river.dao.AdminUserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Resource
	AdminUserDao adminUserDao;
	
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest request,AdminUser adminUser) {
		
		AdminUser admin =  adminUserDao.adminLogin(adminUser);
		if(admin == null) {
			request.setAttribute("adminMsg", "管理员名称或密码有误");
			return "../adminjsps/login.jsp";
		}
		request.getSession().setAttribute("admin", admin);
	
		return "../adminjsps/admin/index.jsp";
	}
}
