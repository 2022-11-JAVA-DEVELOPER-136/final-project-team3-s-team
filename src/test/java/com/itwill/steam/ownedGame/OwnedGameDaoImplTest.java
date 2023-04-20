package com.itwill.steam.ownedGame;
	
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
	
	@Test
	void testOwnedGameList() {
		User user = User.builder().uNo(1).build();
		
		List<OwnedGame> ownedGameList = ownedGameDao.ownedGameList(user);
		System.out.println(">>>>> " + ownedGameList);
		System.out.println(">>>>>"+ownedGameList.get(0).getOgLastplay());
		
	}
	
}	