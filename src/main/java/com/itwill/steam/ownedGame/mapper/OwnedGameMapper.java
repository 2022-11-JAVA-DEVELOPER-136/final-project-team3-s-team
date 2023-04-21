package com.itwill.steam.ownedGame.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.ownedGame.OwnedGame;
import com.itwill.steam.user.User;

@Mapper
public interface OwnedGameMapper {
	public List<OwnedGame> ownedGameList(User user);
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user);
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user);
}