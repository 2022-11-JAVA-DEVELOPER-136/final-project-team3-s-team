package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

@Transactional
class OwnedGameDaoImplTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	@Test
	void testOwnedGameList() {
		List<OwnedGame> ownedGameList = ownedGameDao.ownedGameList(1);
		System.out.println(">>>>> " + ownedGameList);
		
	}
	
}	