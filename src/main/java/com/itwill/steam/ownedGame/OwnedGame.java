package com.itwill.steam.ownedGame;

import java.util.Date;
import java.util.List;

import com.itwill.steam.game.Game;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.resources.Resources;
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
	
	//private List<Resources> resourcesList;
}