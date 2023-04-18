package com.itwill.steam.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.category.Category;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

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
	
	//@Test
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
	
	//@Test
	void testFindAllCategory() {
		List<Category> categoryList = gameService.findAllCategory();
		assertNotNull(categoryList);
		assertNotEquals(categoryList.size(), 0);
		System.out.println(">>>>> "+categoryList);
		System.out.println(">>>>> "+categoryList.size());
	}
	
	//@Test
	void testFindAllTag() {
		List<Tag> tagList = gameService.findAllTag();
		assertNotNull(tagList);
		assertNotEquals(tagList.size(), 0);
		System.out.println(">>>>> "+tagList);
		System.out.println(">>>>> "+tagList.size());
	}
	
	//@Test
	void testFindAllLanguage() {
		List<Language> languageList = gameService.findAllLanguage();
		assertNotNull(languageList);
		assertNotEquals(languageList.size(), 0);
		System.out.println(">>>>> "+languageList);
		System.out.println(">>>>> "+languageList.size());
	}
	
	//@Test
	void testFindNewGames() {
		List<Game> gameList = gameService.findNewGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
		for(Game game:gameList) {
			System.out.println(">>>>> "+game.getGReleaseDate());
		}
	}
	
	//@Test
	void testFindNewGamesByName() {
		List<Game> gameList = gameService.findNewGamesByName("전략");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
		System.out.println(">>>>> "+gameList.size());
	}
	
	@Test
	void testFindGames() {
		List<Game> gameListWithGame = gameService.findGames(SearchDto.builder()
															.orderBy(GameCode.POPULAR)
															.keyword("게임1")
															.categoryList(new ArrayList<Category>(Arrays.asList(Category.builder().ctNo(1).build(),
																Category.builder().ctNo(2).build())))
															.tagList(new ArrayList<Tag>(Arrays.asList(Tag.builder().tagNo(5).build(),
																Tag.builder().tagNo(6).build())))
															.languageList(new ArrayList<Language>(Arrays.asList(Language.builder().langNo(1).build(),
																Language.builder().langNo(2).build())))
															.build());
		assertNotNull(gameListWithGame);
		assertNotEquals(gameListWithGame.size(), 0);
		System.out.println(">>>>> "+gameListWithGame);
		System.out.println(">>>>> "+gameListWithGame.size());
	}
}