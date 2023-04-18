package com.itwill.steam.ownedGame.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.ownedGame.OwnedGame;

@Mapper
public interface OwnedGameMapper {
	public List<OwnedGame> ownedGameList(int uNo);
}