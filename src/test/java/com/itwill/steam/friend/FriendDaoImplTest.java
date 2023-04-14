package com.itwill.steam.friend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class FriendDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private FriendDao friendDao;
	
	//@Test
	
	  void testAddFriend() { Friend friend =
	 Friend.builder().uNo(1).uFNo(3).build(); int result
	  =friendDao.addFriend(friend); System.out.println(result); }
	 
	//@Test
	void testRemoveFriend() {
		friendDao.removeFriend(5);
	}

	
	//@Test
	void testFindFriendByNo() {
		List<Friend> friendList = friendDao.findFriendByNo(1);
		System.out.println(friendList);
	}

}
