package com.itwill.steam.gameLanguage;

import com.itwill.steam.game.Game;
import com.itwill.steam.language.Language;

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
public class GameLanguage {
	private int glNo;
	
	private Game game;
	private Language language;
}