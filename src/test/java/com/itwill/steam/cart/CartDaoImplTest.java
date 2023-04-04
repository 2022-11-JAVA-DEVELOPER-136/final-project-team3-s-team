package com.itwill.steam.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

@Transactional
class CartDaoImplTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	private CartDao cartDao;
	
	@Test
	void testInsertCart() {
		Cart cart = new Cart(0, User.builder().uNo(1).build(), Game.builder().gNo(1).build());
		cartDao.insertCart(cart);
		System.out.println("inserted");
	}
	
	//@Test
	void testSelectCart() {
		
	}
	
	//@Test
	void testSelectAllCart() {
		
	}
	
	//@Test
	void testDeleteCart() {
		
	}
	
	//@Test
	void testDeleteAllCart() {
		
	}
}
