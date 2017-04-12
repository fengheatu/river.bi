package com.river.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex)
			throws Exception {


	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav) throws Exception {
	

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
			
//		User user = (User) request.getSession().getAttribute("user");
//		if(user == null) {
//			System.out.println(111);
////			request.getRequestDispatcher("userjsps/loginregist.jsp").forward(request,response);
//			response.sendRedirect("http://www.baidu.com");
//			return false;
//		}else {
//			System.out.println(222);
			return true;
//		}
		
	}

}
