package com.itwill.steam.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;
	
	// 친구추가
	@Override
	public int addFriend(Friend friend) {
		return friendDao.addFriend(friend);
	}

	// 친구삭제
	@Override
	public int removeFriend(int fNo) {
		return friendDao.removeFriend(fNo);
	}


	// 특정유저친구불러오기
	@Override
	public List<Friend> findFriendByNo(int fNo) {
		return friendDao.findFriendByNo(fNo);
	}

}
