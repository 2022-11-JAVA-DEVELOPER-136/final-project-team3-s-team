package com.itwill.steam.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

@Transactional
class GameServiceImplTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	GameService gameService;

	//@Test
	void testFindAllGames() {
		List<Game> gameList = gameService.findAllGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByName() {
		List<Game> gameList = gameService.findGamesByName("전략");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByCategory() {
		List<Game> gameList = gameService.findGamesByCategory("액션");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByTag() {
		List<Game> gameList = gameService.findGamesByTag("RPG");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindGamesByLanguage() {
		List<Game> gameList = gameService.findGamesByLanguage("한국어");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindPopularGames() {
		List<Game> gameList = gameService.findPopularGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	//@Test
	void testFindDiscountGames() {
		List<Game> gameList = gameService.findDiscountGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	@Test
	void testFindGameByNo() {
		Game game = gameService.findGameByNo(1);
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
		gameService.increaseSellCountByNo(1);
		Game game = gameService.findGameByNo(1);
		assertEquals(game.getGSellCount(), 12);
		System.out.println(">>>>> "+game.getGSellCount());
	}
}