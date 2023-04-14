package com.itwill.steam.friend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class FriendServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	private FriendService friendService;
	
	
	
	  @Test void testAddFriend() { Friend friend = new Friend(0,1, 3);
	 friendService.addFriend(friend); }
	 
	@Test
	void testRemoveFriend() {
		friendService.removeFriend(6);
	}



	@Test
	void testFindFriendByNo() {
		List<Friend> fList =  friendService.findFriendByNo(1);
		System.out.println("친구목록 : "+fList);
	}

}
