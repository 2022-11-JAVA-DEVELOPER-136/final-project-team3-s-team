package com.itwill.steam.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.category.Category;
import com.itwill.steam.exception.GameNotFoundException;
import com.itwill.steam.game.util.PageMaker;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.language.Language;
import com.itwill.steam.review.Review;
import com.itwill.steam.review.ReviewService;
import com.itwill.steam.tag.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GameController {

	private final GameService gameService;
	private final ReviewService reviewService;
	
	//상품리스트 (제목검색, 필터링 가능)
	@RequestMapping(value = "/store")
	public String store(@RequestParam(required = false) String keyword,
						@RequestParam(required = false) String ctNo,
						@RequestParam(required = false) String tagNo,
						@RequestParam(required = false) String langNo,
						@RequestParam(required = false, defaultValue = "1") String pageNo,
						Model model) {
		
		SearchDto searchDto = new SearchDto();
		
		if(!(keyword==null || keyword.equals(""))) {
			searchDto.setKeyword(keyword);
			model.addAttribute("keyword", keyword);
		}
		if(!(ctNo==null || ctNo.equals(""))) {
			List<Category> categoryList = new ArrayList<Category>();
			String[] ctNos = ctNo.split(",");
			for(String ctNoStr:ctNos) {
				categoryList.add(Category.builder().ctNo(Integer.parseInt(ctNoStr)).build());
			}
			searchDto.setCategoryList(categoryList);
			model.addAttribute("ctNo", ctNo);
		}
		if(!(tagNo==null || tagNo.equals(""))) {
			List<Tag> tagList = new ArrayList<Tag>();
			String[] tagNos = tagNo.split(",");
			for(String tagNoStr:tagNos) {
				tagList.add(Tag.builder().tagNo(Integer.parseInt(tagNoStr)).build());
			}
			searchDto.setTagList(tagList);
			model.addAttribute("tagNo", tagNo);
		}
		if(!(langNo==null || langNo.equals(""))) {
			List<Language> languageList = new ArrayList<Language>();
			String[] langNos = langNo.split(",");
			for(String langNoStr:langNos) {
				languageList.add(Language.builder().langNo(Integer.parseInt(langNoStr)).build());
			}
			searchDto.setLanguageList(languageList);
			model.addAttribute("langNo", langNo);
		}
		
		searchDto.setOrderBy(GameCode.POPULAR);
		List<Game> popularGameList = gameService.findGames(searchDto);
		model.addAttribute("popularGameList", popularGameList);
		
		PageMaker pageMaker = new PageMaker(popularGameList.size(), Integer.parseInt(pageNo));//현재 검색하는 조건의 전체 게임 개수를 필요로 한다.
		model.addAttribute("pageMaker", pageMaker);
		
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
	public String storeProduct(@RequestParam(defaultValue = "0") String gNo, Model model, HttpSession session) {
		
		//defaultValue를 "0"으로 설정한 이유 : gNo가 emptyString인 경우를 처리하는 코드를 따로 작성하고 싶지 않아서. (emptyString으로 들어오면, Integer.parseInt()메소드에서 문제 발생.)
		
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
		List<Review> reviewList = reviewService.selectByDateDesc(Game.builder().gNo(Integer.parseInt(gNo)).build());
		model.addAttribute("reviewList", reviewList);
		
		//해당 게임의 리뷰 평균평점 구해서 보내기
		double reviewSum = 0;
		int reviewSize = reviewList.size();
		for(Review review:reviewList) {
			reviewSum += review.getReviewRecommend();
		}
		double reviewAvg = reviewSum / reviewSize / 2;//reviewRecommend가 1~10점이어서 나누기 2 했음.
		model.addAttribute("reviewAvg", reviewAvg);
		
		//해당 게임의 인기리뷰 보여주기 (인기순)
		//메소드없음
		
		//로그인한 경우, 유저의 OwnedGame 검색
		String loginUser = (String)session.getAttribute("loginUser");
		if(loginUser!=null) {
			
		}
		
		return "store-product";
	}
	
	//Local Exception Handler
	@ExceptionHandler(Exception.class)
	public String localExceptionHandler(Exception e) {
		return "redirect:404";
	}
	
	//게임이 없는 경우 404로 redirect
	@ExceptionHandler(GameNotFoundException.class)
	public String gameNotFoundExceptionHandler(GameNotFoundException e) {
		return "redirect:store";
	}
}