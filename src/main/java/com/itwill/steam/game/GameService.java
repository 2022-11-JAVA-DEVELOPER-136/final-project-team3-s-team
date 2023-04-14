package com.itwill.steam.game;

import java.util.List;

import com.itwill.steam.category.Category;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

public interface GameService {
	
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
	
	//인기있는 게임 모아보기 (판매량 내림차순 정렬)
	public List<Game> findPopularGames();
	
	//할인중인 게임 모아보기
	public List<Game> findDiscountGames();
	
	//상품상세보기
	public Game findGameByNo(int gNo);
	
	//상품의 판매량 1 증가
	public int increaseSellCountByNo(int gNo);
	
	/*******************************************/
	
	//카테고리 테이블의 모든 카테고리 검색
	public List<Category> findAllCategory();
	
	//태그 테이블의 모든 태그 검색
	public List<Tag> findAllTag();
	
	//언어 테이블의 모든 언어 검색
	public List<Language> findAllLanguage();
	
	//게임 발매일 순 정렬 (최신순)
	public List<Game> findNewGames();
	
	//상품리스트에서 게임제목으로 검색 - 발매일순 정렬 (최신순 정렬)
	public List<Game> findNewGamesByName(String gName);
	
	/*******************************************/
	
	//상품리스트에서, 같은 카테고리에서 여러 개의 필터를 선택하거나, 서로 다른 카테고리에서 여러 개의 필터를 선택해서 검색하려면 어떻게 구성해야 할까?
	//여러개를 검색????
	public List<Game> findGames(SearchDto searchDto);
}