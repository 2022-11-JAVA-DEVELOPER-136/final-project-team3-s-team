package com.itwill.steam.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.category.Category;
//import com.itwill.steam.game.Game;

@Mapper
public interface CategoryMapper {
	
	/*
	 * //이름으로 카테고리 검색 //public Category selectByName(String ctName);
	 * 
	 * // 번호로 카테고리 검색 // public Category selectByNo(int ctNo);
	 */	
	
	/*
	 * // 상품리스트에서 카테고리 번호로 검색 //public List<Game> findGamesByNo(int ctNo);
	 * 
	 * // 상품리스트에서 카테리고리 이름으로 검색 //public List<Game> findGamesByName(String ctName);
	 */	
	
	// 카테고리 리스트에서 번호로 검색
		public List<Category> findCategoryByNo(int ctNo);
	// 카테고리 리스트에서 이름으로 검색	
		public List<Category> findCategoryByName(String ctName);
	// 카테고리 리스트에서 이미지 검색
		public List<Category> findCategoryByImage(String ctImg);
}