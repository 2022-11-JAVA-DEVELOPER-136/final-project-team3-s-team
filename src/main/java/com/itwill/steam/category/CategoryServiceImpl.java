package com.itwill.steam.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> selectByName(String ctName) {
		return categoryDao.selectByName(ctName);
	}

}
