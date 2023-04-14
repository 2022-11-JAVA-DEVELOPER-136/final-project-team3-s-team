package com.itwill.steam.cart;

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
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	public CartController() {
		
	}
	
		//카트 목록 보기
		//@LoginCheck
		@GetMapping("/cart")
		public String cart(HttpServletRequest request, HttpSession session, Model model) {
			
			User loginUser = (User)session.getAttribute("loginUser");
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("loginUser", loginUser);
		
			return "cart";
		}
		
		//주소 입력창으로 연결
		@GetMapping("/checkout-address")
		public String checkout_address() {
			return "checkout-address";
		}
	
}
