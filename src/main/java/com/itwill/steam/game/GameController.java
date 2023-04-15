package com.itwill.steam.game;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.itwill.steam.exception.GameNotFoundException;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.language.Language;
import com.itwill.steam.review.Review;
import com.itwill.steam.review.ReviewService;
import com.itwill.steam.tag.Tag;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	@Autowired
	private ReviewService reviewService;
	
	public GameController() {
		
	}
	
	//상품리스트 (검색어 x, 필터 x)
	@RequestMapping(value = "/store", params = {"!keyword", "!categoryNo", "!tagNo", "!languageNo"})
	public String store(Model model) {
		
		SearchDto searchDto = new SearchDto();
		
		searchDto.setOrderBy(GameCode.POPULAR);
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		searchDto.setOrderBy(GameCode.NEW);
		List<Game> newGameList = gameService.findGames(searchDto);
		model.addAttribute("newGameList", newGameList);
		
		List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		List<Tag> tagList = gameService.findAllTag();
		model.addAttribute("tagList", tagList);
		
		List<Language> languageList = gameService.findAllLanguage();
		model.addAttribute("languageList", languageList);
		
		return "store";
	}
	
	//상품리스트 (검색어 o, 필터 x)
	@RequestMapping(value = "/store", params = {"keyword", "!categoryNo", "!tagNo", "!languageNo"})
	public String store(@RequestParam String keyword, Model model) {
		
		SearchDto searchDto = new SearchDto();
		
		if(!keyword.equals("")) searchDto.setKeyword(keyword);
		
		searchDto.setOrderBy(GameCode.POPULAR);
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		searchDto.setOrderBy(GameCode.NEW);
		List<Game> newGameList = gameService.findGames(searchDto);
		model.addAttribute("newGameList", newGameList);
		
		List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		List<Tag> tagList = gameService.findAllTag();
		model.addAttribute("tagList", tagList);
		
		List<Language> languageList = gameService.findAllLanguage();
		model.addAttribute("languageList", languageList);
		
		return "store";
	}
	
	//상품리스트 (검색어 o, 필터 o)
	@RequestMapping(value = "/store")
	public String store(@RequestParam String keyword,
						@RequestParam String categoryNo,
						@RequestParam String tagNo,
						@RequestParam String languageNo,
						Model model) {
		
		SearchDto searchDto = new SearchDto();
		
		if(!keyword.equals("")) searchDto.setKeyword(keyword);
		
		if(!categoryNo.equals("")) searchDto.setCategory(Category.builder().ctNo(Integer.parseInt(categoryNo)).build());
		//tag, language는 여러개 받아야한다. 임시로 하나만 받게 했음. 수정해야 함.
		if(!tagNo.equals("")) searchDto.setTagList(new ArrayList<Tag>(Arrays.asList(Tag.builder().tagNo(Integer.parseInt(tagNo)).build())));
		if(!languageNo.equals("")) searchDto.setLanguageList(new ArrayList<Language>(Arrays.asList(Language.builder().langNo(Integer.parseInt(languageNo)).build())));
		
		
		
		searchDto.setOrderBy(GameCode.POPULAR);
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		searchDto.setOrderBy(GameCode.NEW);
		List<Game> newGameList = gameService.findGames(searchDto);
		model.addAttribute("newGameList", newGameList);
		
		List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		List<Tag> tagList = gameService.findAllTag();
		model.addAttribute("tagList", tagList);
		
		List<Language> languageList = gameService.findAllLanguage();
		model.addAttribute("languageList", languageList);
		
		return "store";
	}
	
	//상품상세보기 (파라미터 x)
	@RequestMapping(value = "/store-product", params = "!gNo")
	public String storeProduct() {
		return "redirect:store";
	}
	
	//상품상세보기 (파라미터 o)
	@RequestMapping(value = "/store-product", params = "gNo")
	public String storeProduct(@RequestParam String gNo, Model model) {
		
		if(gNo.equals("")) throw new GameNotFoundException("GameNotFound");//gNo가 emptyString인지 체크. emptyString이면 GameNotFoundException 발생시킴.
		
		//gNo로 게임 검색
		Game game = gameService.findGameByNo(Integer.parseInt(gNo));
		model.addAttribute("game", game);
		
		//해당 게임의 태그로 게임 검색 (유사게임 추천)
		List<Game> gameListByTagName = new ArrayList<Game>();
		Set<Integer> gameNoSetByTagName = new HashSet<Integer>();
		for(GameTag gameTag:game.getGameTagList()) {
			for(Game tempGame:gameService.findGamesByTag(gameTag.getTag().getTagName())) {
				gameNoSetByTagName.add(tempGame.getGNo());//중복되는 게임을 포함시키지 않기 위해 Set 사용
			}
		}
		for(Integer tempGameNo:gameNoSetByTagName) {
			gameListByTagName.add(gameService.findGameByNo(tempGameNo));
		}
		model.addAttribute("gameListByTagName", gameListByTagName);
		
		//해당 게임의 카테고리로 게임 검색 (유사게임 추천)
		List<Game> gameListByCategory = gameService.findGamesByCategory(game.getCategory().getCtName());
		model.addAttribute("gameListByCategory", gameListByCategory);
		
		//해당 게임의 리뷰 보여주기 (최신순) - 아직 메소드 안바뀌어서 최신순 메소드로 안바꿨음 나중에 바꿔야함.
		List<Review> reviewList = reviewService.selectByGameNo(Game.builder().gNo(Integer.parseInt(gNo)).build());
		model.addAttribute("reviewList", reviewList);
		
		//해당 게임의 인기리뷰 보여주기 (인기순)
		//메소드없음
		
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
	
	//Local Exception Handler
	@ExceptionHandler(Exception.class)
	public String localExceptionHandler(Exception e) {
		return "steam_error";
	}
	
	//게임이 없는 경우 404로 redirect
	@ExceptionHandler(GameNotFoundException.class)
	public String gameNotFoundExceptionHandler(GameNotFoundException e) {
		return "redirect:404";
	}
}