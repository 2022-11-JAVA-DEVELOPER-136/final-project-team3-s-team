package com.itwill.steam.wishList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.user.User;

@Controller
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	public WishListController() {
		
		}
	
		//찜목록 리스트 보기
		//@LoginCheck
		@GetMapping("/wishList")
		public String wishList(HttpServletRequest request, HttpSession session, Model model) {
			
			User loginUser = (User)session.getAttribute("loginUser");
			List<WishList> wishListList = wishListService.selectWishList(loginUser.getUNo());
			
			model.addAttribute("wishListList", wishListList);
			model.addAttribute("loginUser", loginUser);
		
			return "wishList";
			}
		
		//상품 페이지로 연결
		@RequestMapping("/store-product")
		public String store_product() {
			return "store-product";
		}
	
	}
