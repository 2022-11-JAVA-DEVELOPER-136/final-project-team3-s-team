package com.itwill.steam.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.category.Category;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

@Transactional
class GameDaoImplTest extends FinalProjectTeam3STeamApplicationTests {

	@Autowired
	private GameDao gameDao;
	
	//@Test
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
		System.out.println(">>>>> "+game.getCategoryList());
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
	
	//@Test
	void testFindAllCategory() {
		List<Category> categoryList = gameDao.findAllCategory();
		assertNotNull(categoryList);
		assertNotEquals(categoryList.size(), 0);
		System.out.println(">>>>> "+categoryList);
		System.out.println(">>>>> "+categoryList.size());
	}
	
	//@Test
	void testFindAllTag() {
		List<Tag> tagList = gameDao.findAllTag();
		assertNotNull(tagList);
		assertNotEquals(tagList.size(), 0);
		System.out.println(">>>>> "+tagList);
		System.out.println(">>>>> "+tagList.size());
	}
	
	//@Test
	void testFindAllLanguage() {
		List<Language> languageList = gameDao.findAllLanguage();
		assertNotNull(languageList);
		assertNotEquals(languageList.size(), 0);
		System.out.println(">>>>> "+languageList);
		System.out.println(">>>>> "+languageList.size());
	}
	
	@Test
	void testFindNewGames() {
		List<Game> gameList = gameDao.findNewGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
		for(Game game:gameList) {
			System.out.println(">>>>> "+game.getGReleaseDate());
		}
	}
}