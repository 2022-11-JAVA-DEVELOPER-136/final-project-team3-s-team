package com.itwill.steam.category;

import java.util.List;

import com.itwill.steam.game.Game;

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
public class Category {
	private int ctNo;
	private String ctName;
	private String ctImg;
	
	private List<Game> gameList;
}