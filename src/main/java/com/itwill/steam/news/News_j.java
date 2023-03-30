package com.itwill.steam.news;

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
public class News_j {
	private int newsNo;
	private String newsTitle;
	private String newsContent;
	private String newsImg;
	
	private Game game;
}