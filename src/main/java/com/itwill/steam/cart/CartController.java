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
		//@RequestMapping("/checkout-order")
		public String checkoutOrder(HttpServletRequest request, HttpSession session, Model model) {
			
			User loginUser = (User)session.getAttribute("loginUser");
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("loginUser", loginUser);
		
			return "checkout-order";
		}
		
		//주소 입력창으로 연결
		@RequestMapping("/checkout-address")
		public String checkout_address() {
			return "checkout-address";
		}
		
		/*
		@GetMapping(value = "/notice-list")
		public String notice_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
									Model model, HttpSession session) {
			
			try {
				if(session != null) {
					User loginUser = (User)session.getAttribute("loginUser");
					model.addAttribute("loginUser",loginUser);
				}
				PageMakerDto<Notice> noticeListPage = noticeService.selectAll(pageNo);
				List<Notice> noticeList = noticeListPage.getItemList();
				model.addAttribute("noticeListPage", noticeListPage);
				model.addAttribute("noticeList", noticeList);
				model.addAttribute("pageNo", pageNo);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			return "notice-list";
		}
	*/
}
