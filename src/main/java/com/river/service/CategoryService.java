package com.river.service;

import java.util.List;

import com.river.entity.Category;

public interface CategoryService {

	/**
	 * 获取所有的分类信息
	 * @return 返回一个List集合
	 */
	public abstract List<Category> getAllCategory();
	
	
	/**
	 * 添加一个商品分类
	 * @param category
	 */
	public abstract void adminAddCategory(Category category);

	/**
	 * 通过分类Id删除分类信息
	 * @param parameter
	 */
	public abstract void adminDelCategory(String categoryId);

	/**
	 * 通过Id查询分类信息
	 * @param parameter
	 */
	public abstract Category adminFindBycategoryId(String categoryId);

	/**
	 * 修改分类信息
	 * @param category
	 */
	public abstract void adminUpdateCategory(Category category);
}
