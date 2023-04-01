package com.itwill.steam.friend.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.steam.friend.Friend;

public interface FriendMapper {
	// 친구추가
	public int addFriend(Friend friend);

	// 친구삭제
	public int removeFriend(int fNo);

	// 친구상태업데이트
	public int updateFriendState(Map<String, Object> map);

	// 특정유저친구불러오기
	public List<Friend> findFriendByNo(int fNo);

}
