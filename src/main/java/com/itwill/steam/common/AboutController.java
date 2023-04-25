package com.itwill.steam.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.game.GameService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AboutController {
	
	private final GameService gameService;
	
	@RequestMapping("/about")
	public String about() {
		
		
		
		return "about";
	}
}