package com.itwill.steam.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//import com.itwill.steam.category.Category;
import com.itwill.steam.game.Game;

@Mapper
public interface CategoryMapper {
	
	//이름으로 카테고리 검색
		//public Category selectByName(String ctName);
	
	// 상품리스트에서 카테고리 번호로 검색
		public List<Game> findGamesByNo(int ctNo);
			
	// 상품리스트에서 카테리고리 이름으로 검색
		public List<Game> findGamesByName(String ctName);
	
}