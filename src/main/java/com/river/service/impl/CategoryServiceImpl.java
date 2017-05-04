package com.river.service.impl;

import com.river.dao.CategoryDao;
import com.river.entity.Category;
import com.river.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategory() {
		
		return categoryDao.getAllCategory();
	}

	@Override
	@Transactional
	public void adminAddCategory(Category category) {
		
		categoryDao.adminAddCategory(category);
	}

	@Override
	@Transactional
	public void adminDelCategory(String categoryId) {
		categoryDao.adminDelCategory(categoryId);
		
	}

	@Override
	public Category adminFindBycategoryId(String categoryId) {
		
		return categoryDao.adminFindBycategoryId(categoryId);
	}

	@Override
	@Transactional
	public void adminUpdateCategory(Category category) {
		
		categoryDao.adminUpdateCategory(category);
	}

}
