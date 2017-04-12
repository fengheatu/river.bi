package com.river.controller;

import com.river.entity.Category;
import com.river.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {
	
	@Resource
	CategoryService categorySerice;
	
	@RequestMapping("/findAllCategory")
	public String getAllCategory(HttpServletRequest request) {
		List<Category> categoryList = categorySerice.getAllCategory();
		request.setAttribute("categoryList", categoryList);
		
		return "userjsps/main.jsp";
	}
	
	
}
