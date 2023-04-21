package com.itwill.steam.ownedGame;

import java.util.List;

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

}
