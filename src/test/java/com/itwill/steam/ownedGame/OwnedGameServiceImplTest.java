package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.GameService;
	
class OwnedGameServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	OwnedGameService ownedGameService;
	
	@Test
	void testOwnedGameList() {
		List<OwnedGame> ownedGameList = ownedGameService.ownedGameList(1);
		System.out.println(">>>>> " + ownedGameList);
	}
	
}	