package com.itwill.steam.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	public CartController() {
		
	}
	
	
	
}
