package com.itwill.steam.category;

import java.util.List;

public interface CategoryService {
	
	public List<Category> selectByName(String ctName);
}
