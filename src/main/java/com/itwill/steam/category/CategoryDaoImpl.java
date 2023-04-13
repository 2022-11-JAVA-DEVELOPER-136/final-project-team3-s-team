package com.itwill.steam.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.category.mapper.CategoryMapper;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findCategoryByNo(int ctNo) {
		
		return null;
	}

	@Override
	public List<Category> findCategoryByName(String ctName) {
		
		return null;
	}
	
	
}
