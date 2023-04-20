package com.itwill.steam.ownedGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.user.User;

@Service
public class OwnedGameServiceImpl implements OwnedGameService {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	//user의 uNo로 해당 유저의 ownedGameList를 찾아서 반환
	@Override
	public List<OwnedGame> ownedGameList(User user) {
		return ownedGameDao.ownedGameList(user);
	}
	
}