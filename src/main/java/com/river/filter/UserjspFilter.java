package com.river.filter;

import com.river.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserjspFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resq = (HttpServletResponse) response;

		User user = (User) req.getSession().getAttribute("user");

		if (user == null) {
			resq.sendRedirect(req.getContextPath()
					+ "/userjsps/loginregist.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
