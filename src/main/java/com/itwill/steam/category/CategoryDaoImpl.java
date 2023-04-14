package com.itwill.steam.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.category.mapper.CategoryMapper;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> selectByName(String ctName) {
		return categoryMapper.selectByName(ctName);
	}

}