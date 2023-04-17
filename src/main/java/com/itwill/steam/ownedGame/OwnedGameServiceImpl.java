package com.itwill.steam.ownedGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class OwnedGameServiceImpl implements OwnedGameService {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	@Override
	public List<OwnedGame> ownedGameList(int uNo) {
		return ownedGameDao.ownedGameList(uNo);
	}
	
}