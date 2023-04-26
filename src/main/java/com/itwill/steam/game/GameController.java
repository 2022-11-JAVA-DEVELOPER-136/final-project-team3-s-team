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

import com.itwill.steam.cart.Cart;
import com.itwill.steam.cart.CartService;
import com.itwill.steam.category.Category;
import com.itwill.steam.exception.ExistedWishListException;
import com.itwill.steam.exception.GameNotFoundException;
import com.itwill.steam.game.util.PageMaker;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.language.Language;
import com.itwill.steam.ownedGame.OwnedGame;
import com.itwill.steam.ownedGame.OwnedGameService;
import com.itwill.steam.review.Review;
import com.itwill.steam.review.ReviewService;
import com.itwill.steam.tag.Tag;
import com.itwill.steam.user.User;
import com.itwill.steam.user.UserService;
import com.itwill.steam.wishList.WishList;
import com.itwill.steam.wishList.WishListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GameController {

	private final GameService gameService;
	private final ReviewService reviewService;
	private final OwnedGameService ownedGameService;
	private final CartService cartService;
	private final WishListService wishListService;
	
	//상품리스트 (제목검색, 필터링 가능)
	@RequestMapping(value = "/store")
	public String store(@RequestParam(required = false) String keyword,
						@RequestParam(required = false) String ctNo,
						@RequestParam(required = false) String tagNo,
						@RequestParam(required = false) String langNo,
						@RequestParam(required = false, defaultValue = "1") String pageNo,
						Model model,
						HttpSession session) {
		
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
		
		/***** discount *****/
//		searchDto.setOrderBy(GameCode.POPULAR);
//		searchDto.setIsDiscount(GameCode.DISCOUNT);
//		List<Game> discountPopularGameList = gameService.findGames(searchDto);
//		model.addAttribute("discountPopularGameList", discountPopularGameList);
//		PageMaker discountPageMaker = new PageMaker(discountPopularGameList.size(), Integer.parseInt(pageNo));
//		model.addAttribute("discountPageMaker", discountPageMaker);
		/********************/
		
		List<Tag> tagList = gameService.findAllTag();
		model.addAttribute("tagList", tagList);
		
		List<Language> languageList = gameService.findAllLanguage();
		model.addAttribute("languageList", languageList);
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser!=null) {
			int cartQuantity = cartService.countCart(((User)session.getAttribute("loginUser")).getUNo());
			model.addAttribute("cartQuantity", cartQuantity);
			
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
	        model.addAttribute("cartList", cartList);
		}
		/*************************************/
		
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
		
		//해당 게임의 리뷰 보여주기 (최신순)
		List<Review> reviewList = reviewService.selectByDateDesc(game);
		model.addAttribute("reviewList", reviewList);
		
		//해당 게임의 인기리뷰 보여주기 (인기순)
		List<Review> reviewListPopular = reviewService.selectByLikeDesc(game);
		model.addAttribute("reviewListPopular", reviewListPopular);
		
		//해당 게임의 리뷰 평균평점 구해서 보내기
		double reviewSum = 0;
		int reviewSize = reviewList.size();
		for(Review review:reviewList) {
			reviewSum += review.getReviewRecommend();
		}
		double reviewAvg = reviewSum / reviewSize / 2;//reviewRecommend가 1~10점이어서 나누기 2 했음.
		model.addAttribute("reviewAvg", reviewAvg);
		if(reviewSize==0) model.addAttribute("reviewAvg", 0);
		
		//로그인한 경우, 유저의 OwnedGame 검색
		User loginUser = (User)session.getAttribute("loginUser");
		String isLogin = "false";
		String isExistLibrary = "false";
		String isExistCart = "false";
		String isExistWishlist = "false";
		
		if(loginUser!=null) {
			model.addAttribute("loginUser", loginUser);
			isLogin = "true";
			
			List<OwnedGame> ownedGameList = ownedGameService.ownedGameList(loginUser);
			for(OwnedGame ownedGame:ownedGameList) {
				if(game.getGNo()==ownedGame.getGame().getGNo()) isExistLibrary = "true";
			}
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
			for(Cart cart:cartList) {
				if(game.getGNo()==cart.getGame().getGNo()) isExistCart = "true";
			}
			List<WishList> wishLists = wishListService.selectWishList(loginUser.getUNo());
			for(WishList wishList:wishLists) {
				if(game.getGNo()==wishList.getGame().getGNo()) isExistWishlist = "true";
			}
			
			model.addAttribute("cartList", cartList);
		}
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("isExistLibrary", isExistLibrary);
		model.addAttribute("isExistCart", isExistCart);
		model.addAttribute("isExistWishlist", isExistWishlist);
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		if(session.getAttribute("loginUser")!=null) {
			int cartQuantity = cartService.countCart(((User)session.getAttribute("loginUser")).getUNo());
			model.addAttribute("cartQuantity", cartQuantity);
		}
		/*************************************/
		
		return "store-product";
	}
	
	//Local Exception Handler : 404로 redirect
	@ExceptionHandler(Exception.class)
	public String localExceptionHandler(Exception e) {
		//e.printStackTrace();
		return "redirect:404";
	}
	
	//GameNotFoundException 발생 시 store로 redirect
	@ExceptionHandler(GameNotFoundException.class)
	public String gameNotFoundExceptionHandler(GameNotFoundException e) {
		return "redirect:store";
	}
	
	//ExistedWishListException 발생 시 store로 redirect
	@ExceptionHandler(ExistedWishListException.class)
	public String existedWishListExceptionHandler(ExistedWishListException e) {
		return "redirect:store";
	}
}