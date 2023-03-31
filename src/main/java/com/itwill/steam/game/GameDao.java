package com.itwill.steam.game;

import java.util.List;

public interface GameDao {
	
	//상품리스트 전체검색
	public List<Game> findAllGames();
	
	//상품리스트에서 게임제목으로 검색
	public List<Game> findGamesByName(String gName);
	
	//상품리스트에서 카테고리로 필터링
	public List<Game> findGamesByCategory(String ctName);
	
	//상품리스트에서 태그로 필터링
	public List<Game> findGamesByTag(String tagName);
	
	//상품리스트에서 언어로 필터링
	public List<Game> findGamesByLanguage(String langName);
}