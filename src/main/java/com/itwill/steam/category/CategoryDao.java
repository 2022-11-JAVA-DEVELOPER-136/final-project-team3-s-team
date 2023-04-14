package com.itwill.steam.category;

import java.util.List;

public interface CategoryDao {
	
	//카테고리 이름으로 검색
	public List<Category> selectByName(String ctName);
}
