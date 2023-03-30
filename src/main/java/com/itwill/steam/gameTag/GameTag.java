package com.itwill.steam.gameTag;

import com.itwill.steam.game.Game;
import com.itwill.steam.tag.Tag;

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
public class GameTag {
	private int gtNo;
	
	private Tag tag;
	private Game game;
}