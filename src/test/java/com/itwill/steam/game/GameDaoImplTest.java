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
	
	//@Test
	void testFindAllGames() {
		List<Game> gameList = gameDao.findAllGames();
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
	}
	
	//@Test
	void testFindGamesByName() {
		List<Game> gameList = gameDao.findGamesByName("전략");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
	}
	
	//@Test
	void testFindGamesByCategory() {
		List<Game> gameList = gameDao.findGamesByCategory("액션");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
	}
	
	//@Test
	void testFindGamesByTag() {
		List<Game> gameList = gameDao.findGamesByTag("RPG");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
	}
	
	@Test
	void testFindGamesByLanguage() {
		List<Game> gameList = gameDao.findGamesByLanguage("한국어");
		assertNotNull(gameList);
		assertNotEquals(gameList.size(), 0);
		System.out.println(">>>>> "+gameList);
	}
}