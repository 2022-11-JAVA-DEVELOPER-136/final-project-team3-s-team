package com.itwill.steam.ownedGame.mapper;

import java.util.List;

import com.itwill.steam.ownedGame.OwnedGame;

public interface OwnedGameMapper {
	public List<OwnedGame> ownedGameList(int uNo);
}