package com.itwill.steam.ownedGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.user.User;

@Service
public class OwnedGameServiceImpl implements OwnedGameService {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	//user의 uNo로 해당 유저의 ownedGameList를 찾아서 반환(플레이시간 많은순)
	@Override
	public List<OwnedGame> ownedGameList(User user) {
		return ownedGameDao.ownedGameList(user);
	}
	//플레이시간 상위4개 게임리스트
	@Override
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user) {
		
		return ownedGameDao.getTop4OwnedGamesByPlaytime(user);
	}
	//최근플레이 3개 게임리스트
	@Override
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user) {
		
		return ownedGameDao.getTop4OwnedGamesByLastTime(user);
	}
	
}