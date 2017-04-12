package com.river.service;

import java.util.List;
import java.util.Map;

import com.river.entity.Snacks;

public interface SnacksService {

	
	/**
	 * 按Id查询单条记录
	 * @param snacksId 查血记录Id
	 * @return Snacks 返回单条记录
	 */
	public abstract Snacks findById(String snacksId);
	
	 /**
	  * 查询总记录数
	  * @return 返回数据库中的总记录数
	  */
	public abstract long getTotalcount();
	
	/**
	 * 分页管理
	 * @param page  起始页
	 * @param pageSize 页面大小
	 * @return 返回一个list集合
	 */
	public abstract  List<Snacks> getPageBean(Map<String,Object> map);
	
	/**
	 * 通过分类Id查询该分类的全部商品
	 * @param map
	 * @return
	 */
	public abstract List<Snacks> findByCategoryId(Map<String, Object> map);

	
	/**
	 * 获取该分类的总记录数
	 * @param categoryId
	 * @return
	 */
	public abstract long getTotalcountByCategory(String categoryId);
	
	/**
	 * 关键字查询
	 * @param map
	 * @return
	 */
	public abstract List<Snacks> keywordSearch(Map<String, Object> map);
	
	
	/**
	 * 通过关键字查询该关键字的总记录数
	 * @param map
	 * @return
	 */
	public abstract long getTotalcountByKeyword(Map<String, Object> map);
	
	/**
	 * 修改商品信息
	 * @param snacks
	 */
	public abstract void adminUpdateSnacksById(Snacks snacks);
	
	
	/**
	 * 添加商品信息
	 * @param snacks
	 */
	public abstract void adminAddSnacks(Snacks snacks);
	
}
