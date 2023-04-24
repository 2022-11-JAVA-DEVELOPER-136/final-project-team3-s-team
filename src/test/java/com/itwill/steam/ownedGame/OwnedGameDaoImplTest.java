package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.user.User;
import com.itwill.steam.user.UserDao;

@Transactional
class OwnedGameDaoImplTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	//@Test
	void testOwnedGameList() {
		User user = User.builder().uNo(1).build();
		
		List<OwnedGame> ownedGameList = ownedGameDao.ownedGameList(user);
		System.out.println(">>>>> " + ownedGameList);
		System.out.println(">>>>>"+ownedGameList.get(0).getOgLastplay());
		
	}
	
	//@Test
	void testInsertOwnedGame() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", 1);
		map.put("gNo", 2);
		ownedGameDao.insertOwnedGame(map);
	}
	
	//@Test
	void testExistOwnedGame() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", 1);
		map.put("gNo", 1);
		assertEquals(ownedGameDao.existOwnedGame(map), 1);
		map.put("gNo", 4);
		assertEquals(ownedGameDao.existOwnedGame(map), 0);
	}
	
	@Test
	void testFindOwnedGame() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", 1);
		map.put("gNo", 1);
		assertNotNull(ownedGameDao.findOwnedGame(map));
		map.put("gNo", 4);
		assertNull(ownedGameDao.findOwnedGame(map));
	}
}	