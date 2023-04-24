package com.itwill.steam.wishList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

class WishListServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private WishListService wishListService;
	
	//@Test
	void testInsertWishList() {
		User user = User.builder().uNo(1).build();
		Game game = Game.builder().gNo(1).build();
//		WishList wishList = new WishList(1, null,user,game);
//		wishListService.insertWishList(wishList);
	}

	@Test
	void testSelectWishList() {
		List<WishList> wishlistList = wishListService.selectWishList(2);
		System.out.println(">>>>>"+wishlistList);
		System.out.println(">>>>>"+wishlistList.size());
	}

	//@Test
	void testDeleteWishList() {
		wishListService.deleteWishList(1);
	}

	//@Test
	void testDeleteAllWishLists() {
		wishListService.deleteAllWishLists(1);
	}

}
