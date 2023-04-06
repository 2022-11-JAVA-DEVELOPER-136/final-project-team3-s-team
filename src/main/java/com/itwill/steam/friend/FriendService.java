package com.itwill.steam.friend;

import java.util.List;

public interface FriendService {
	// 친구추가
	public int addFriend(Friend friend);

	// 친구삭제
	public int removeFriend(int fNo);

	// 친구상태업데이트
	public int updateFriendState(int fNo,int fState);

	// 특정유저친구불러오기
	public List<Friend> findFriendByNo(int fNo);
}
