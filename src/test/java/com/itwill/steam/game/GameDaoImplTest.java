package com.itwill.steam.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

@Transactional
class GameDaoImplTest extends FinalProjectTeam3STeamApplicationTests {

	@Autowired
	private GameDao gameDao;
	
	@Test
	void testFindAllGames() {
		List<Game> gameList = gameDao.findAllGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByName() {
		List<Game> gameList = gameDao.findGamesByName("전략");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByCategory() {
		List<Game> gameList = gameDao.findGamesByCategory("액션");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByTag() {
		List<Game> gameList = gameDao.findGamesByTag("RPG");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByLanguage() {
		List<Game> gameList = gameDao.findGamesByLanguage("한국어");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindPopularGames() {
		List<Game> gameList = gameDao.findPopularGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindDiscountGames() {
		List<Game> gameList = gameDao.findDiscountGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGameByNo() {
		Game game = gameDao.findGameByNo(1);
		assertNotNull(game);
		System.out.println(">>>>> "+game);
		System.out.println(">>>>> "+game.getCategory());
		System.out.println(">>>>> "+game.getResourcesList().size()+game.getResourcesList());
		System.out.println(">>>>> "+game.getGameTagList().size()+game.getGameTagList());
		System.out.println(">>>>> "+game.getGameLanguageList().size()+game.getGameLanguageList());
		System.out.println(">>>>> "+game.getNewsList().size()+game.getNewsList());
		System.out.println(">>>>> "+game.getReviewList().size()+game.getReviewList());
	}
	
	//@Test
	void testIncreaseSellCountByNo() {
		gameDao.increaseSellCountByNo(1);
		Game game = gameDao.findGameByNo(1);
		assertEquals(game.getGSellCount(), 12);
		System.out.println(">>>>> "+game.getGSellCount());
	}
}