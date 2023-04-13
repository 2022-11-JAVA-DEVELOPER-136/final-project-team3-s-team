package com.itwill.steam.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	public OrderController() {
		
	}
	
	public String welcome() {
		return "redirect:steam_main";
	}
	
	
}
