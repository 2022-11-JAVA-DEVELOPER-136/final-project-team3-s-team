package com.itwill.steam.friend;

import java.util.List;

public interface FriendService {
	// 친구추가
	public int addFriend(Friend friend);

	// 친구삭제
	public int removeFriend(int fNo);


	// 특정유저친구불러오기
	public List<Friend> findFriendByNo(int fNo);
}
