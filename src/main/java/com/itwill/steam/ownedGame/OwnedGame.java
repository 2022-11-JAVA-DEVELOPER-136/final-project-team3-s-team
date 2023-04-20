package com.itwill.steam.ownedGame;

import java.util.Date;

import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OwnedGame {
	private int ogNo; 
	private int ogPlaytime; 
	private Date ogLastplay;
	
	private User user;
	private Game game;
}