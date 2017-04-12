package com.river.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.river.entity.Category;
import com.river.entity.Snacks;
import com.river.service.CategoryService;
import com.river.service.SnacksService;
import com.river.utils.CreateUUID;
import com.river.utils.PageBean;

@Controller
@RequestMapping("/admin")
public class AdminSnacksController {
	
	@Resource
	SnacksService snacksService;
	
	@Resource
	CategoryService categoryService;
	
	@RequestMapping("/showSnacks")
	public String showSnacks(HttpServletRequest request, @RequestParam int page) {
		showAllSnacks(request, page);
		return "../adminjsps/admin/snacks/list.jsp";
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
		String queryString = request.getQueryString();
		String url = contextPath + servletPath + "?" + queryString;
		if (url.contains("page=")) {
			int index = url.indexOf("page=");
			return url.substring(0, index);
		} else {
			return url;
		}
	}
	
	@RequestMapping("/findSnacksById")
	public String findSnacksById(HttpServletRequest request) {
		
		request.setAttribute("snacks",snacksService.findById(request.getParameter("snacksId")));
		List<Category> categoryList = categoryService.getAllCategory();
		request.setAttribute("categoryList", categoryList);
		return "../adminjsps/admin/snacks/desc.jsp";
	}
	
	@RequestMapping("/adminUpdateSnacksById")
	public String adminUpdateSnacksById(@RequestParam("image") MultipartFile image,HttpServletRequest request) {
		
		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"image/";
		String filename = null;
		
		
		if(!(image.getOriginalFilename().isEmpty())) {
			filename =  CreateUUID.uuid() + image.getOriginalFilename();
		
			File dir = new File(uploadUrl);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			File targetFile = new File(uploadUrl + filename);
			if(!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			
			try {
				image.transferTo(targetFile);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}else {
			filename = request.getParameter("image");

		}
		
		
		Snacks snacks = new Snacks();
		snacks.setSnacksId(request.getParameter("snacksId"));
		snacks.setSnackName(request.getParameter("snackName"));
		snacks.setState(Integer.valueOf(request.getParameter("state")));
		snacks.setCategoryId(request.getParameter("categoryId"));
		snacks.setDescription(request.getParameter("description"));
		snacks.setImage(filename);
		snacks.setPrice(Double.valueOf(request.getParameter("price")));
		snacksService.adminUpdateSnacksById(snacks);
		showAllSnacks(request, 1);
		return "../adminjsps/admin/snacks/list.jsp";
	}
	
	
	
	public void showAllSnacks(HttpServletRequest request,int page) {
		if (page <= 0) {
			page = 1;
		}
		int pageSize = 45;
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
		request.setAttribute("pageBean", pageBean);
	}
	
	@RequestMapping("/adminAddSnacks")
	public String adminAddSnacks(@RequestParam("image") MultipartFile image,HttpServletRequest  request) {
		
		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"image/";
		String filename =  CreateUUID.uuid() + image.getOriginalFilename();
		File dir = new File(uploadUrl);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File targetFile = new File(uploadUrl + filename);
		if(!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		try {
			image.transferTo(targetFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		Snacks snacks = new Snacks();
		snacks.setSnacksId(CreateUUID.uuid());
		snacks.setImage(filename);
		snacks.setCategoryId(request.getParameter("categoryId"));
		snacks.setDescription(request.getParameter("description"));
		snacks.setPrice(Double.valueOf(request.getParameter("price")));
		snacks.setSnackName(request.getParameter("snackName"));
		snacks.setState(Integer.valueOf(request.getParameter("state")));
		snacksService.adminAddSnacks(snacks);
		request.setAttribute("msg", "添加成功");
		request.setAttribute("categoryList",categoryService.getAllCategory());
		return "../adminjsps/admin/snacks/add.jsp";
	}
}