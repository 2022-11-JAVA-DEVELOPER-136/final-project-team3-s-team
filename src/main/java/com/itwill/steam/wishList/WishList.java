package com.itwill.steam.wishList;

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
public class WishList {
	
	private int wishNo;
	private Date wishDate;//찜 요일
	
	private User user;
	private Game game;
}