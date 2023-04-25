package com.itwill.steam.game;

import java.util.List;

import com.itwill.steam.category.Category;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SearchDto {
	
	//findGames() 메소드의 인자로 사용
	
	/*
	 * keyword, category, tagList, languageList 끼리는 AND 연산
	 * 
	 * categoryList, tagList, languageList 안의 Category, Tag, Language는 OR 연산
	 */
	
	private String keyword;//검색어로 게임제목 검색
	private List<Category> categoryList;
	private List<Tag> tagList;
	private List<Language> languageList;
	private int orderBy;//정렬방법: 인기순(1) OR 최신순(2) -> GameCode의 상수 사용.
	private int isDiscount;//할인여부: 할인X(0) OR 할인O(3) -> GameCode의 상수 사용.
}