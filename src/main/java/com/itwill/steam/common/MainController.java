package com.itwill.steam.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.steam.cart.Cart;
import com.itwill.steam.cart.CartService;
import com.itwill.steam.category.Category;
import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameCode;
import com.itwill.steam.game.GameService;
import com.itwill.steam.game.SearchDto;
import com.itwill.steam.ownedGame.OwnedGame;
import com.itwill.steam.ownedGame.OwnedGameService;
import com.itwill.steam.review.Review;
import com.itwill.steam.review.ReviewService;
import com.itwill.steam.user.LoginCheck;
import com.itwill.steam.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final GameService gameService;
	private final CartService cartService;
	private final OwnedGameService ownedGameService;
	private final ReviewService reviewService;
	
	//메인 페이지
	@RequestMapping("/main")
	public String main(Model model, HttpSession session) {
		
		String isLogin = "false";
		
		SearchDto searchDto = SearchDto.builder().orderBy(GameCode.POPULAR).build();
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		searchDto.setOrderBy(GameCode.NEW);
		List<Game> newGameList = gameService.findGames(searchDto);
		model.addAttribute("newGameList", newGameList);
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser!=null) {
			model.addAttribute("loginUser", loginUser);
			isLogin = "true";
			
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
	        model.addAttribute("cartList", cartList);
			
			int cartQuantity = cartService.countCart(((User)session.getAttribute("loginUser")).getUNo());
			model.addAttribute("cartQuantity", cartQuantity);
			
			List<OwnedGame> ownedGameList = ownedGameService.ownedGameList(loginUser);
			//model.addAttribute("ownedGameList", ownedGameList);
			List<Integer> ogameList = new ArrayList<Integer>();
			for(OwnedGame ownedGame:ownedGameList) {
				ogameList.add(ownedGame.getGame().getGNo());
			}
			model.addAttribute("ogameList", ogameList);
		}
		model.addAttribute("isLogin", isLogin);
		/*************************************/
		
		return "main";
	}
	
	//라이브러리 - 파라미터 x
	//@LoginCheck
	@RequestMapping(value = "/library", params = "!gNo")
	public String library(HttpSession session, RedirectAttributes redirectAttributes) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null) return "redirect:main";
		
		redirectAttributes.addAttribute("tab", 2);
		
		return "redirect:profile";
	}
	
	//라이브러리 - 파라미터 o
	//@LoginCheck
	@RequestMapping(value = "/library", params = "gNo")//나중에 post로 바꾸자
	public String library(@RequestParam String gNo, Model model, HttpSession session) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null) return "redirect:main";
		
		if(gNo.equals("")) return "redirect:library";
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		int cartQuantity = cartService.countCart(loginUser.getUNo());
		model.addAttribute("cartQuantity", cartQuantity);
		List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
        model.addAttribute("cartList", cartList);
		/*************************************/
		
		Game game = gameService.findGameByNo(Integer.parseInt(gNo));
		model.addAttribute("game", game);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", loginUser.getUNo());
		map.put("gNo", Integer.parseInt(gNo));
		OwnedGame ownedGame = ownedGameService.findOwnedGame(map);
		if(ownedGame==null) return "redirect:library";//라이브러리에 없는 게임에 접근하려고 하면 프로필의 게임탭으로 redirect
		
		model.addAttribute("ownedGame", ownedGame);
		
		List<Review> reviewList = reviewService.selectByDateDesc(game);
		
		//해당 게임의 리뷰 평균평점 구해서 보내기
		double reviewSum = 0;
		int reviewSize = reviewList.size();
		for(Review review:reviewList) {
			reviewSum += review.getReviewRecommend();
		}
		double reviewAvg = reviewSum / reviewSize / 2;//reviewRecommend가 1~10점이어서 나누기 2 했음.
		model.addAttribute("reviewAvg", reviewAvg);
		
		return "library";
	}
	
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
	
	//root
	@GetMapping("/")
	public String welcome() {
		return "redirect:main";
	}
	
	//404 page
	@RequestMapping("/404")
	public String fileNotFoundError() {
		return "404";
	}
	
	//steam_main
	//@RequestMapping("/steam_main")
	public String steamMain() {
		return "steam_main";
	}
	
	/***************************** template test start *****************************/
	/*
	@RequestMapping("/coming_soon")
	public String comingSoon() {
		return "coming_soon";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("/forum")
	public String forum() {
		return "forum";
	}
	@RequestMapping("/forum-topic")
	public String forumTopic() {
		return "forum-topic";
	}
	@RequestMapping("/help-center")
	public String helpCenter() {
		return "help-center";
	}
	@RequestMapping("/help-center-article")
	public String helpCenterArticle() {
		return "help-center-article";
	}
	@RequestMapping("/news")
	public String news() {
		return "news";
	}
	@RequestMapping("/news-article")
	public String newsArticle() {
		return "news-article";
	}
	@RequestMapping("/one-page")
	public String onePage() {
		return "one-page";
	}
	@RequestMapping("/private-messaging")
	public String privateMessaging() {
		return "private-messaging";
	}
	*/
	/****************************** template test end ******************************/
}