package com.itwill.steam.ownedGame;

import java.util.List;

import com.itwill.steam.user.User;

public interface OwnedGameDao {
	public List<OwnedGame> ownedGameList(User user);
}