package com.itwill.steam.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	public GameController() {
		
	}
	
	//메인화면
	@RequestMapping("/steam_main")
	public String steam_main() {
		return "steam_main";
	}
	
	//상품리스트 화면
	@RequestMapping("/steam_list")
	public String steam_list() {
		return "steam_list";
	}
	
	//상품리스트에서 제목 검색
	@RequestMapping("/steam_search")
	public String steam_search() {
		return "steam_search";
	}
	
	//상품리스트에서 필터링 (카테고리, 태그, 언어)
	@RequestMapping("/steam_filtering")
	public String steam_filtering() {
		return "steam_filtering";
	}
	
	//POST방식으로 요청해야 하는 method에 GET방식으로 요청하는 경우, steam_main으로 redirect
	@GetMapping({})
	public String game_get() {
		return "redirect:steam_main";
	}
	
	//Local Exception Handler
	@ExceptionHandler(Exception.class)
	public String exception_handler(Exception e) {
		return "steam_error";
	}
}