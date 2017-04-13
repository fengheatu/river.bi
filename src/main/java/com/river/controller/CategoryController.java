package com.river.controller;

import com.river.entity.Category;
import com.river.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Resource
	CategoryService categorySerice;
	
	@RequestMapping("/findAllCategory")
	public String getAllCategory(HttpServletRequest request) {
		List<Category> categoryList = categorySerice.getAllCategory();
		logger.info("商品类型" + categoryList);
		request.setAttribute("categoryList", categoryList);

		return "userjsps/main.jsp";
	}
	
	
}
