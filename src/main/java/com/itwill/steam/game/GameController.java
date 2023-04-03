package com.itwill.steam.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	public GameController() {
		
	}
	
	@RequestMapping("/steam_main")
	public String steam_main() {
		return "steam_main";
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public String exception_handler(Exception e) {
		return "steam_error";
	}
}