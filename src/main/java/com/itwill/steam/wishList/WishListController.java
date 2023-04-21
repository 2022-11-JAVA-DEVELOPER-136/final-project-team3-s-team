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
	public String wishlist(HttpServletRequest request, HttpSession session, Model model) {

		User loginUser = (User) session.getAttribute("loginUser");
		List<WishList> wishlist = wishListService.selectWishList(loginUser.getUNo());

		model.addAttribute("wishlist", wishlist);
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