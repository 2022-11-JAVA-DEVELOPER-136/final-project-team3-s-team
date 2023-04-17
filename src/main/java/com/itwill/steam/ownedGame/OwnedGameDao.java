package com.itwill.steam.ownedGame;

import java.util.List;

public interface OwnedGameDao {
	public List<OwnedGame> ownedGameList(int uNo);
}