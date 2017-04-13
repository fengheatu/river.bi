package com.river.controller;

import com.river.entity.Category;
import com.river.entity.Snacks;
import com.river.service.CategoryService;
import com.river.service.SnacksService;
import com.river.utils.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SnacksController {

	private static final Logger logger = LoggerFactory.getLogger(SnacksController.class);

	@Resource
	SnacksService snacksService;

	@Resource
	CategoryService categoryService;

	@RequestMapping("/showSnacks")
	public String showSnacks(HttpServletRequest request, @RequestParam int page) {

		logger.info("显示第【"+page+"】页商品");

		if (page <= 0) {
			page = 1;
		}
		int pageSize = 44;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", ((page - 1) * pageSize));
		map.put("pageSize", pageSize);
		List<Snacks> snacksList = snacksService.getPageBean(map);
		PageBean<Snacks> pageBean = new PageBean<Snacks>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeanList(snacksList);
		pageBean.setTotalcount(snacksService.getTotalcount());
		pageBean.setUrl(getUrl(request));
		List<Category> categoryList = categoryService.getAllCategory();
		request.getSession().setAttribute("categoryList", categoryList);
		request.setAttribute("pageBean", pageBean);
		return "/userjsps/main.jsp";
	}

	@RequestMapping("/findByCategoryId")
	public String findByCategoryId(HttpServletRequest request,
			@RequestParam int page, String categoryId) {

		logger.info("查询【" + categoryId +"】类商品");

		if (page <= 0) {
			page = 1;
		}
		int pageSize = 44;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", ((page - 1) * pageSize));
		map.put("pageSize", pageSize);
		map.put("categoryId", categoryId);
		List<Snacks> snacksList = snacksService.findByCategoryId(map);
		PageBean<Snacks> pageBean = new PageBean<Snacks>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeanList(snacksList);
		pageBean.setTotalcount(snacksService
				.getTotalcountByCategory(categoryId));
		pageBean.setUrl(getUrl(request));
		request.setAttribute("pageBean", pageBean);
		return "/userjsps/main.jsp";
	}

	@RequestMapping("/keywordSearch")
	public String keywordSearch(HttpServletRequest request,
			@RequestParam Double startPrice, Double endPrice, String keyword,
			int page) {
		if (page <= 0) {
			page = 1;
		}
		int pageSize = 44;

		logger.info("按条件查询 startPrice【" + startPrice+"】endPrice【"+endPrice+"】keyword【"+keyword+"】");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		map.put("page", ((page - 1) * pageSize));
		map.put("pageSize", pageSize);
		System.out.println(keyword);
		map.put("keyword", "%" + encoding(keyword) + "%");
		List<Snacks> snacksList = snacksService.keywordSearch(map);
		PageBean<Snacks> pageBean = new PageBean<Snacks>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeanList(snacksList);
		pageBean.setTotalcount(snacksService.getTotalcountByKeyword(map));
		pageBean.setUrl(getUrl(request));
		request.setAttribute("pageBean", pageBean);
		return "/userjsps/main.jsp";

	}

	/**
	 * get请求中文乱码问题
	 * 
	 * @param keyword
	 * @return
	 */
	private String encoding(String keyword) {

		try {
			return new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取请求连接
	 * 
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = encoding(request.getQueryString());
		String url = contextPath + servletPath + "?" + queryString;
		if (url.contains("page=")) {
			int index = url.indexOf("page=");
			return url.substring(0, index);
		} else {
			return url;
		}
	}
	
	@RequestMapping("/snacksdetails")
	public String snacksdetails(HttpServletRequest request) {
		request.setAttribute("snacks",
				snacksService.findById(request.getParameter("snacksId")));
		return "userjsps/snacksdetails.jsp";
	}
}