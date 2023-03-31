package com.itwill.steam.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.game.mapper.GameMapper;

@Repository
public class GameDaoImpl implements GameDao {

	@Autowired
	private GameMapper gameMapper;
	
	//상품리스트 전체검색
	@Override
	public List<Game> findAllGames() {
		return gameMapper.findAllGames();
	}
	
	//상품리스트에서 게임제목으로 검색
	@Override
	public List<Game> findGamesByName(String gName) {
		return gameMapper.findGamesByName(gName);
	}

	//상품리스트에서 카테고리로 필터링
	@Override
	public List<Game> findGamesByCategory(String ctName) {
		return gameMapper.findGamesByCategory(ctName);
	}

	//상품리스트에서 태그로 필터링
	@Override
	public List<Game> findGamesByTag(String tagName) {
		return gameMapper.findGamesByTag(tagName);
	}

	//상품리스트에서 언어로 필터링
	@Override
	public List<Game> findGamesByLanguage(String langName) {
		return gameMapper.findGamesByLanguage(langName);
	}
	
	//인기있는 게임 모아보기 (판매량 내림차순 정렬)
	@Override
	public List<Game> findPopularGames() {
		return gameMapper.findPopularGames();
	}

	//할인중인 게임 모아보기
	@Override
	public List<Game> findDiscountGames() {
		return gameMapper.findDiscountGames();
	}

	//상품상세보기
	@Override
	public Game findGameByNo(int gNo) {
		return gameMapper.findGameByNo(gNo);
	}

	//상품의 판매량 1 증가
	@Override
	public int increaseSellCountByNo(int gNo) {
		return gameMapper.increaseSellCountByNo(gNo);
	}
}