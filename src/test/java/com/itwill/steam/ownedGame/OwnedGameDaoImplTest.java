package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
	
class OwnedGameDaoImplTest {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	@Test
	void testOwnedGameList() {
		List<OwnedGame> ownedGameList = ownedGameDao.ownedGameList(1);
		assertNotNull(ownedGameList);
		System.out.println(">>>>> " + ownedGameList);
		
	}
	
}	