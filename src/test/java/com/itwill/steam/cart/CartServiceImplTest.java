package com.itwill.steam.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

@Transactional
class CartServiceImplTest extends FinalProjectTeam3STeamApplicationTests {

	@Autowired
	private CartService cartService;
	
	//@Test
	void testInsertCart() {
		Cart cart = new Cart(0, User.builder().uNo(1).build(), Game.builder().gNo(1).build());
		cartService.insertCart(cart);
		System.out.println("inserted");
	}

	//@Test
	void testSelectCart() {
		System.out.println(">>>>"+cartService.selectCart(1));
	}
	
	//@Test
	void testDeleteCart() {
		System.out.println(">>>>"+cartService.deleteCart(1));
	}
	
	//@Test
	void testDeleteAllCarts() {
		cartService.deleteAllCarts(1);
		System.out.println("deleted");
	}

	@Test
	void testCountCart() {
		assertEquals(cartService.countCart(1), 3);
	}
}