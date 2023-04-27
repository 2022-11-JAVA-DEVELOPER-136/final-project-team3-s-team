package com.itwill.steam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.cart.Cart;
import com.itwill.steam.cart.CartService;
import com.itwill.steam.category.Category;
import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameService;
import com.itwill.steam.game.SearchDto;
import com.itwill.steam.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AboutController {
	
	private final GameService gameService;
	private final CartService cartService;
	
	@RequestMapping("/about")
	public String about(Model model, HttpSession session) {
		
		SearchDto searchDto = new SearchDto();
		
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser!=null) {
			int cartQuantity = cartService.countCart(loginUser.getUNo());
			model.addAttribute("cartQuantity", cartQuantity);
			
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
	        model.addAttribute("cartList", cartList);
		}
		/*************************************/
		
		return "about";
	}
}