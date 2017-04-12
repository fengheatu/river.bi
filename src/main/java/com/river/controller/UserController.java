package com.river.controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Buffer;
import com.river.entity.Cartitem;
import com.river.entity.User;
import com.river.service.CartitemService;
import com.river.service.UserService;
import com.river.utils.CreateUUID;
import com.river.utils.Mail;
import com.river.utils.MailUtils;
import com.river.utils.ResponseUtil;
import com.river.utils.VerifyCode;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	UserService userService;
	
	@Resource
	CartitemService cartitemService;

	/**
	 * 用户登录方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * 校验验证码
		 */
		String session_verifycode = (String) request.getSession().getAttribute("session_verifycode");
		String verifycode = request.getParameter("verifycode");
		if(!session_verifycode.equalsIgnoreCase(verifycode)){
			request.setAttribute("verifycodeMsg", "验证码不正确");
			return "../userjsps/loginregist.jsp";
		}
		
		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		if (request.getParameterValues("checkbox") != null) {
			setCookie(response, phone);
		} else {
			removeCookie(response, phone);
		}
		User user = new User();
		user.setPassword(password);
		user.setPhone(phone);
		User userReturn = userService.login(user);
		if (userReturn != null) {
			request.getSession().setAttribute("user", userReturn);
			List<Cartitem> cartitemList = cartitemService.findCartitemListByUserId(userReturn.getUserId());
			request.getSession().setAttribute("cartitemList", cartitemList);
			int count = 0;
			for(Cartitem _cartitem : cartitemList) {
				
				count += _cartitem.getAmount();
			}
			request.getSession().setAttribute("count", count);
			return "../index.jsp";
		} else {
			request.setAttribute("loginMsg", "用户名或密码错误");
			return "../userjsps/loginregist.jsp";
		}
	}

	/**
	 * 添加cookie
	 * 
	 * @param request
	 * @param cookieName
	 */
	public void setCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie("cookiePhone", cookieName);
		cookie.setMaxAge(60 * 60 * 24 * 7);
		cookie.setPath("/websnacksstore/userjsps/");
		response.addCookie(cookie);
	}

	/**
	 * 删除cookie
	 * 
	 * @param request
	 * @param cookieName
	 */
	public void removeCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie("cookiePhone", cookieName);
		cookie.setMaxAge(0);
		cookie.setPath("/websnacksstore/userjsps/");
		response.addCookie(cookie);
	}

	/**
	 * 用户注册方法
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request) {
		User user = new User();
		user.setUserId(CreateUUID.uuid());
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		userService.regist(user);
		return "../userjsps/loginregist.jsp";
	}

	/**
	 * 用户注册时校验手机号码是否已经本注册
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkUserForRegist")
	public void checkUserForRegist(HttpServletRequest request,
			HttpServletResponse response) {
		String checkPhone = request.getParameter("phone");
		String phone = userService.checkUserForRegist(checkPhone);
		if (phone != null) {
			try {
				ResponseUtil.write(response, "该手机号码已经被注册");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 用户注销方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");

		return "../index.jsp";
	}

	/**
	 * 找回密码时校验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/phoneMatchEmail")
	public void phoneMatchEmail(HttpServletRequest request,
			HttpServletResponse response) {
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		String findEmail = userService.findEmailByPhone(phone);
		if (!findEmail.equals(email)) {
			ResponseUtil.write(response, "该手机号码" + phone + "未绑定该邮箱" + email
					+ ",请重新确认！");
		}

	}

	@RequestMapping("/email")
	public String sendEmail(HttpServletRequest request,
			HttpServletResponse response) {
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		sendEmail(email);
		request.getSession().setAttribute("phone", phone);
		return "../index.jsp";
	}

	/**
	 * 发送邮件
	 * 
	 * @param email
	 */
	public void sendEmail(String email) {

		FileInputStream inStream = null;

		try {
			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream("email.properties");
			Properties prop = new Properties();
			prop.load(in);
			String host = prop.getProperty("mail.host");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String myEmail = prop.getProperty("email");
			String theme = prop.getProperty("theme");
			String content = prop.getProperty("content");
			Session session = MailUtils.createSession(host, username, password);

			Mail mail = new Mail(myEmail, email, theme, content);

			MailUtils.send(session, mail);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/changePassword")
	public String changePassword(HttpServletRequest request) {

		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		userService.changePassword(user);

		return "../userjsps/loginregist.jsp";
	}
	
	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response) {
		
		VerifyCode vc = new VerifyCode();
		BufferedImage image =  vc.getImage();
		request.getSession().setAttribute("session_verifycode", vc.getText());
		try {
			VerifyCode.output(image, response.getOutputStream());
		} catch (IOException e) {
				throw new RuntimeException(e);
		}
	}
	
	@RequestMapping("/regist_check_verifycode")
	public void regist_check_verifycode(HttpServletRequest request,HttpServletResponse response) {
		String session_verifycode = (String) request.getSession().getAttribute("session_verifycode");
		String verifycode = request.getParameter("verifycode");
		
		if(!session_verifycode.equalsIgnoreCase(verifycode)) {
			ResponseUtil.write(response, "验证码不正确");
		}
	}
}
