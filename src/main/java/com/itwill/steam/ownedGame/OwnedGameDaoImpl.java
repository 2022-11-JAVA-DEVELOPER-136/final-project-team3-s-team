package com.itwill.steam.ownedGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.ownedGame.mapper.OwnedGameMapper;

@Repository
public class OwnedGameDaoImpl implements OwnedGameDao {

	@Autowired
	private OwnedGameMapper ownedGameMapper;
	
	@Override
	public List<OwnedGame> ownedGameList(int uNo) {
		return ownedGameMapper.ownedGameList(uNo);
	}

}
