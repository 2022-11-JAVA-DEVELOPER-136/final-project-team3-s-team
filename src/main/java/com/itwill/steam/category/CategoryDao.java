package com.itwill.steam.category;

import java.util.List;

//import com.itwill.steam.game.Game;

public interface CategoryDao {
	
	// 카테리고리 리스트에서 번호로 검색
		public List<Category> findCategoryByNo(int ctNo);
		
	// 카테리고리 리스트에서 이름으로 검색
		public List<Category> findCategoryByName(String ctName);
		
	// 카테고리 리스트에서  이미지 검색
		public List<Category> findCategoryByImage(String ctImg);
	
}
