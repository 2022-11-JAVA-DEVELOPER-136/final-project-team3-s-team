package com.itwill.steam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameService;
import com.itwill.steam.game.SearchDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AboutController {
	
	private final GameService gameService;
	
	@RequestMapping("/about")
	public String about(Model model, HttpSession session) {
		
		SearchDto searchDto = new SearchDto();
		
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		return "about";
	}
}