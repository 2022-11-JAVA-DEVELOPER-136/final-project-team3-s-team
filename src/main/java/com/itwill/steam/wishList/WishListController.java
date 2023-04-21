package com.itwill.steam.wishList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameService;
import com.itwill.steam.user.User;

@Controller
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@Autowired
	private GameService gameService;
	
	
	
	public WishListController() {
		
	}

	// 위시리스트 추가
	@PostMapping("/insert-wishlist")
	public String insertWishList(@RequestParam String uNo, @RequestParam String gNo) {

		if (uNo == null || gNo == null) {
			return "redirect:main";
		}

		WishList wishList = WishList.builder().user(User.builder().uNo(Integer.parseInt(uNo)).build())
				.game(Game.builder().gNo(Integer.parseInt(gNo)).build()).build();
		int result = wishListService.insertWishList(wishList);

		/*
		 * if (result > 0) { redirectAttributes.addFlashAttribute("message",
		 * "상품이 성공적으로 추가되었습니다."); } else {
		 * redirectAttributes.addFlashAttribute("message", "상품 추가에 실패했습니다."); }
		 */

		return "redirect:profile";
	}

	// 리스트 목록 보기
	@GetMapping(value = "/wishlist")
	public String wishlist_find_user_no(HttpSession session, Model model) {
		//세션에서 로그인한 사용자 정보를 가져와서 'loginUser'변수에 저장
		User loginUser = (User) session.getAttribute("loginUser");
		//로그인유저의 번호를 사용해서 위시리스트를 조회하고 그 결과를 wishlist에 저장
		List<WishList> wishlist = wishListService.selectWishList(loginUser.getUNo());
		//조회된 wishlist를 'wishlist'라는 이름으로 model에 저장
		model.addAttribute("wishlist", wishlist);
		//로그인한 사용자 정보를 'loginUser'라는 이름으로 model에 저장
		model.addAttribute("loginUser", loginUser);

		return "wishlist";
	}

	/*
	 * // store-product 페이지로 이동
	 * 
	 * @RequestMapping(value = "/store-product", method = RequestMethod.GET) public
	 * String storeproduct(HttpSession session, Model model) {
	 * 
	 * User loginUser = (User)session.getAttribute("loginUser"); //List<Game>
	 * gameList = gameService.find(loginUser.getUNo());
	 * 
	 * //model.addAttribute("gameList", gameList); model.addAttribute("loginUser",
	 * loginUser);
	 * 
	 * return "store-product"; }
	 */

	/*
	 * // profile 페이지로 이동
	 * 
	 * @RequestMapping(value = "/profile", method = RequestMethod.GET) public String
	 * profile(HttpSession session, Model model) {
	 * 
	 * User loginUser = (User)session.getAttribute("loginUser");
	 * 
	 * 
	 * model.addAttribute("loginUser", loginUser);
	 * 
	 * return "profile"; }
	 */

}