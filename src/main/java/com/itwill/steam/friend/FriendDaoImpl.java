package com.itwill.steam.friend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.friend.mapper.FriendMapper;

@Repository
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	private FriendMapper friendMapper;
	
	@Override
	public int addFriend(Friend friend) {
		
		return friendMapper.addFriend(friend);
	}

	@Override
	public int removeFriend(int fNo) {
		
		return friendMapper.removeFriend(fNo);
	}


	@Override
	public List<Friend> findFriendByNo(int fNo) {
		
		return friendMapper.findFriendByNo(fNo);
	}

}
