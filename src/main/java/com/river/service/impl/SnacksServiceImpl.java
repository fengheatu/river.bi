package com.river.service.impl;

import com.river.dao.SnacksDao;
import com.river.entity.Snacks;
import com.river.service.SnacksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SnacksServiceImpl implements SnacksService {
	
	@Resource
	SnacksDao snacksDao;
	
	@Override
	public Snacks findById(String snacksId) {
		
		return snacksDao.findById(snacksId);
	}

	@Override
	public long getTotalcount() {
		
		return snacksDao.getTotalcount();
	}

	@Override
	public List<Snacks> getPageBean(Map<String,Object> map) {
		
		return snacksDao.getPageBean(map);
	}

	@Override
	public List<Snacks> findByCategoryId(Map<String, Object> map) {

		return snacksDao.findByCategoryId(map);
	}

	@Override
	public long getTotalcountByCategory(String categoryId) {
		
		return snacksDao.getTotalcountByCategory(categoryId);
	}

	@Override
	public List<Snacks> keywordSearch(Map<String, Object> map) {
	
		return snacksDao.keywordSearch(map);
	}

	@Override
	public long getTotalcountByKeyword(Map<String, Object> map) {
		
		return snacksDao.getTotalcountByKeyword(map);
	}


	@Override
	public void adminUpdateSnacksById(Snacks snacks) {
		
		snacksDao.adminUpdateSnacksById(snacks);
		
	}

	@Override
	public void adminAddSnacks(Snacks snacks) {
	
		snacksDao.adminAddSnacks( snacks);
		
	}

}
