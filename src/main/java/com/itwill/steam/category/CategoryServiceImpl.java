package com.itwill.steam.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> findCategoryByNo(int ctNo) {
		
		return categoryDao.findCategoryByNo(ctNo);
	}

	@Override
	public List<Category> findCategoryByName(String ctName) {
		
		return categoryDao.findCategoryByName(ctName);
	}

	@Override
	public List<Category> findCategoryByImage(String ctImg) {
		
		return categoryDao.findCategoryByImage(ctImg);
	}

}
