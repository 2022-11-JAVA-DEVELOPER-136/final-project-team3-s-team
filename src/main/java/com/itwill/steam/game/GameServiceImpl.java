package com.itwill.steam.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.category.Category;
import com.itwill.steam.exception.GameNotFoundException;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDao gameDao;

	//상품리스트 전체검색
	@Override
	public List<Game> findAllGames() {
		return gameDao.findAllGames();
	}

	//상품리스트에서 게임제목으로 검색
	@Override
	public List<Game> findGamesByName(String gName) {
		return gameDao.findGamesByName(gName);
	}

	//상품리스트에서 카테고리로 필터링
	@Override
	public List<Game> findGamesByCategory(String ctName) {
		return gameDao.findGamesByCategory(ctName);
	}

	//상품리스트에서 태그로 필터링
	@Override
	public List<Game> findGamesByTag(String tagName) {
		return gameDao.findGamesByTag(tagName);
	}

	//상품리스트에서 언어로 필터링
	@Override
	public List<Game> findGamesByLanguage(String langName) {
		return gameDao.findGamesByLanguage(langName);
	}

	//인기있는 게임 모아보기 (판매량 내림차순 정렬)
	@Override
	public List<Game> findPopularGames() {
		return gameDao.findPopularGames();
	}

	//할인중인 게임 모아보기
	@Override
	public List<Game> findDiscountGames() {
		return gameDao.findDiscountGames();
	}

	//상품상세보기
	@Override
	public Game findGameByNo(int gNo) {
		Game game = gameDao.findGameByNo(gNo);
		if(game==null) {
			//game이 null인지 체크. null이면 GameNotFoundException 발생시킴. (없는 게임번호로 검색한 경우)
			throw new GameNotFoundException("GameNotFound");
		}
		return game;
	}

	//상품의 판매량 1 증가
	@Override
	public int increaseSellCountByNo(int gNo) {
		return gameDao.increaseSellCountByNo(gNo);
	}

	//카테고리 테이블의 모든 카테고리 검색
	@Override
	public List<Category> findAllCategory() {
		return gameDao.findAllCategory();
	}

	//태그 테이블의 모든 태그 검색
	@Override
	public List<Tag> findAllTag() {
		return gameDao.findAllTag();
	}

	//언어 테이블의 모든 언어 검색
	@Override
	public List<Language> findAllLanguage() {
		return gameDao.findAllLanguage();
	}

	//게임 발매일 순 정렬 (최신순)
	@Override
	public List<Game> findNewGames() {
		return gameDao.findNewGames();
	}

	//상품리스트에서 게임제목으로 검색 - 발매일순 정렬 (최신순 정렬)
	@Override
	public List<Game> findNewGamesByName(String gName) {
		return gameDao.findNewGamesByName(gName);
	}

	//search 통합 중
	@Override
	public List<Game> findGames(SearchDto searchDto) {
		return gameDao.findGames(searchDto);
	}
}