package com.itwill.steam.game.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.game.Game;

@Mapper
public interface GameMapper {
	
	//상품리스트 보여주기
	public List<Game> findAllGames();
}