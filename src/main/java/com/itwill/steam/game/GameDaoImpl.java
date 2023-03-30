package com.itwill.steam.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.game.mapper.GameMapper;

@Repository
public class GameDaoImpl implements GameDao {

	@Autowired
	private GameMapper gameMapper;
	
	//상품리스트 보여주기
	@Override
	public List<Game> findAllGames() {
		return gameMapper.findAllGames();
	}
}