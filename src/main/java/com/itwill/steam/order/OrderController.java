package com.itwill.steam.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.card.Card;
import com.itwill.steam.card.CardService;
import com.itwill.steam.user.LoginCheck;
import com.itwill.steam.user.User;
import com.itwill.steam.user.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CardService cardService;
	@Autowired
	private UserService userService;
	
	public OrderController() {
		
	}
	//주소 불러오기
	@RequestMapping(value = "/checkout-address")
	public String checkoutAddress(HttpServletRequest request) throws Exception{
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser==null) {
			return "redirect:main";
		}
		request.setAttribute("loginUser", loginUser);
		return "checkout-address";
	}
	//카드 불러오기
	
	@RequestMapping(value = "/checkout-payment")
	public String checkoutCard(HttpServletRequest request) throws Exception {
		User loginUser =(User)request.getSession().getAttribute("loginUser");
		
		Card card=cardService.findCardByNo(loginUser.getUNo());
		request.setAttribute("card", card);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+card);
		return "checkout-payment";
	}
	//라이브러리로 정보 옮기기
}