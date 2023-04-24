package com.itwill.steam.wishList;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;


class WishListDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private WishListDao wishListDao;
	
	//@Test
	void testInsertWishList() {
		User user = User.builder().uNo(1).build();
		Game game = Game.builder().gNo(1).build();
//		WishList wishList = new WishList(1, null,user,game);
//		wishListDao.insertWishList(wishList);
	}

	@Test
	void testSelectWishList() {
		wishListDao.selectWishList(1);
		
	}

	//@Test
	void testDeleteWishList() {
		wishListDao.deleteWishList(1);
	}

	//@Test
	void testDeleteAllWishLists() {
		wishListDao.deleteAllWishLists(1);
	}

}
