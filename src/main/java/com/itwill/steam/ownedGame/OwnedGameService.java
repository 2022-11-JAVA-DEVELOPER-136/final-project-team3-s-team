package com.itwill.steam.ownedGame;

import java.util.List;
import java.util.Map;

import com.itwill.steam.user.User;

public interface OwnedGameService {
	public List<OwnedGame> ownedGameList(User user);
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user);
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user);
	
	//주문이 끝날 때 해당 주문의 주문아이템을 해당 유저의 라이브러리에 입력 (uNo, gNo의 조합이 이미 라이브러리에 존재한다면 Exception)
	public int insertOwnedGame(Map<String, Object> map);
	
	//uNo, gNo를 사용해서 OwnedGame 1개 검색
	public OwnedGame findOwnedGame(Map<String, Object> map);
}