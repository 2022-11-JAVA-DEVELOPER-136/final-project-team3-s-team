package com.itwill.steam.ownedGame;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.ownedGame.mapper.OwnedGameMapper;
import com.itwill.steam.user.User;

@Repository
public class OwnedGameDaoImpl implements OwnedGameDao {

	@Autowired
	private OwnedGameMapper ownedGameMapper;
	
	@Override
	public List<OwnedGame> ownedGameList(User user) {
		return ownedGameMapper.ownedGameList(user);
	}

	@Override
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user) {
		
		return ownedGameMapper.getTop4OwnedGamesByPlaytime(user);
	}

	@Override
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user) {
		// TODO Auto-generated method stub
		return ownedGameMapper.getTop4OwnedGamesByLastTime(user);
	}

	//주문이 끝날 때 해당 주문의 주문아이템을 해당 유저의 라이브러리에 입력
	@Override
	public int insertOwnedGame(Map<String, Object> map) {
		return ownedGameMapper.insertOwnedGame(map);
	}

	//유저의 라이브러리에 해당 게임이 존재하는지 확인
	@Override
	public int existOwnedGame(Map<String, Object> map) {
		return ownedGameMapper.existOwnedGame(map);
	}

	//uNo, gNo를 사용해서 OwnedGame 1개 검색
	@Override
	public OwnedGame findOwnedGame(Map<String, Object> map) {
		return ownedGameMapper.findOwnedGame(map);
	}
}