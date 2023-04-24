package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.GameService;
import com.itwill.steam.user.User;

@Transactional
class OwnedGameServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	OwnedGameService ownedGameService;
	
	//@Test
	void testOwnedGameList() {
		
		User user = User.builder().uNo(1).build();
		
		List<OwnedGame> ownedGameList = ownedGameService.getTop4OwnedGamesByLastTime(user);
		System.out.println(">>>>> " + ownedGameList);
	}
	
//	@Test
	void testInsertOwnedGame() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", 1);
		map.put("gNo", 2);
		ownedGameService.insertOwnedGame(map);
	}
	
	@Test
	void testFindOwnedGame() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", 1);
		map.put("gNo", 1);
		assertNotNull(ownedGameService.findOwnedGame(map));
		map.put("gNo", 4);
		assertNull(ownedGameService.findOwnedGame(map));
	}
}