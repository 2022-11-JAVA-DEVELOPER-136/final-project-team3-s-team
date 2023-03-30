package com.itwill.steam.game;

import java.util.List;

public interface GameDao {
	
	//상품리스트 보여주기
	public List<Game> findAllGames();
}