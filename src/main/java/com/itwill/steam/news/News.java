package com.itwill.steam.news;

import java.util.Date;

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
public class News {
	private int newsNo;
	private String newsTitle;
	private String newsHeader;
	private String newsContent;
	private String newsImg;
	private Date newsCreatedAt;
	private Date newsUpdatedAt;
	
	private Game game;
}