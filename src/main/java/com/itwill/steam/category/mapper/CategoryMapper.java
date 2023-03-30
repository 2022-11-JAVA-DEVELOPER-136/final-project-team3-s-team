package com.itwill.steam.category.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.category.Category;

@Mapper
public interface CategoryMapper {
	
	//이름으로 카테고리 검색
	public Category selectByName(String ctName);
}