package com.itwill.steam.orderItem;

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
public class OrderItem {
	private int oiNo;
	
	private int oNo;//?
	private Game game;
}