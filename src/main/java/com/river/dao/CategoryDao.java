package com.river.dao;

import com.river.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
	
	/**
	 * 获取所有的分类信息
	 * @return 返回一个List集合
	 */
	public abstract List<Category> getAllCategory();

	
	/**
	 * 添加一个商品分类信息
	 * @param category
	 */
	public abstract void adminAddCategory(Category category);

	
	/**
	 * 通过分类Id删除分类信息
	 * @param categoryId
	 */
	public abstract void adminDelCategory(String categoryId);

	/**
	 * 通过分类Id查找分类信息
	 * @param categoryId
	 */
	public abstract Category adminFindBycategoryId(String categoryId);

	/**
	 * 修改分类信息
	 * @param category
	 */
	public abstract void adminUpdateCategory(Category category);
	
	
	/**
	 * 通过分类Id查找分类信息
	 * @param categoryId
	 */
	public abstract Category findBycategoryId(String categoryId);
	
}
