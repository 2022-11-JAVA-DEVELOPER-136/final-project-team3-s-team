package com.itwill.steam.ownedGame;

import java.util.List;

import com.itwill.steam.user.User;

public interface OwnedGameService {
	public List<OwnedGame> ownedGameList(User user);
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user);
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user);
}