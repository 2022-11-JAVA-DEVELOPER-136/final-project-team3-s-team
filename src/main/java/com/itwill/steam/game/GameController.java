package com.itwill.steam.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	public GameController() {
		
	}
	
	//root
	@GetMapping("/")
	public String welcome() {
		return "redirect:steam_main";
	}
	
	//메인화면
	@RequestMapping("/steam_main")
	public String steamMain() {
		return "steam_main";
	}
	
	//상품리스트 화면
	@RequestMapping("/game_list")
	public String gameList(Model model) {
		
		List<Game> gameList = gameService.findAllGames();
		model.addAttribute("gameList", gameList);
		
		return "game_list";
	}
	
	//상품 상세보기
	@RequestMapping("/game_detail")
	public String gameDetail(Model model) {
		
		Game game = gameService.findGameByNo(1);
		model.addAttribute("game", game);
		
		return "game_detail";
	}
	
	//상품리스트에서 제목 검색
	@RequestMapping("/game_search")
	public String gameSearch() {
		return "game_search";
	}
	
	//상품리스트에서 필터링 (카테고리, 태그, 언어)
	@RequestMapping("/game_filtering")
	public String gameFiltering() {
		return "game_filtering";
	}
	
	//POST방식으로 요청해야 하는 method에 GET방식으로 요청하는 경우, steam_main으로 redirect
	//@GetMapping({})
	public String gameGet() {
		return "redirect:steam_main";
	}
	
	//Local Exception Handler
	@ExceptionHandler(Exception.class)
	public String localExceptionHandler(Exception e) {
		return "steam_error";
	}
	 
	
	
	/***************************** template test start *****************************/
	@RequestMapping("/404")
	public String fileNotFoundError() {
		return "404";
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	@RequestMapping("/checkout-address")
	public String checkoutAddress() {
		return "checkout-address";
	}
	@RequestMapping("/checkout-order")
	public String checkoutOrder() {
		return "checkout-order";
	}
	@RequestMapping("/checkout-payment")
	public String checkoutPayment() {
		return "checkout-payment";
	}
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
	@RequestMapping("/main")
	public String main() {
		return "main";
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
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}
	@RequestMapping("/store")
	public String store() {
		return "store";
	}
	@RequestMapping("/store-product")
	public String storeProduct() {
		return "store-product";
	}
	/****************************** template test end ******************************/
}