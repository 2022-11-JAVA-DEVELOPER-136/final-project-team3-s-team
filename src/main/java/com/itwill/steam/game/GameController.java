package com.itwill.steam.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.category.Category;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.language.Language;
import com.itwill.steam.tag.Tag;

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
	@RequestMapping("/store")
	public String gameList(Model model) {
		
		List<Game> popularGameList = gameService.findPopularGames();
		List<Game> newGameList = gameService.findNewGames();
		List<Category> categoryList = gameService.findAllCategory();
		List<Tag> tagList = gameService.findAllTag();
		List<Language> languageList = gameService.findAllLanguage();
		
		model.addAttribute("popularGameList", popularGameList);
		model.addAttribute("newGameList", newGameList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("tagList", tagList);
		model.addAttribute("languageList", languageList);
		
		return "store";
	}
	
	//상품상세보기 (파라미터 x)
	@RequestMapping(value = "/store-product", params = "!gNo")
	public String gameDetail() {
		return "redirect:store";
	}
	
	//상품상세보기 (파라미터 o)
	@RequestMapping(value = "/store-product", params = "gNo")
	public String gameDetail(@RequestParam int gNo, Model model) {
		
		//gNo로 게임 검색
		Game game = gameService.findGameByNo(gNo);
		model.addAttribute("game", game);
		
		//해당 게임의 태그로 게임 검색 (유사 제품 추천)
		List<Game> gameListByTagName = new ArrayList<Game>();
		Set<Game> gameSetByTagName = new HashSet<Game>();
		for(GameTag gameTag:game.getGameTagList()) {
			for(Game tempGame:gameService.findGamesByTag(gameTag.getTag().getTagName())) {
				gameSetByTagName.add(tempGame);
			}
		}
		for(Game tempGame:gameSetByTagName) {
			gameListByTagName.add(tempGame);
		}
		model.addAttribute("gameListByTagName", gameListByTagName);
		
		return "store-product";
	}
	
	//상품리스트에서 제목 검색
	//@RequestMapping("/game_search")
	public String gameSearch() {
		return "game_search";
	}
	
	//상품리스트에서 필터링 (카테고리, 태그, 언어)
	//@RequestMapping("/game_filtering")
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
	//@RequestMapping("/store")
	public String store() {
		return "store";
	}
	//@RequestMapping("/store-product")
	public String storeProduct() {
		return "store-product";
	}
	/****************************** template test end ******************************/
}