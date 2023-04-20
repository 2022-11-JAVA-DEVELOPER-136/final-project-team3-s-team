package com.itwill.steam.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.card.Card;
import com.itwill.steam.card.CardService;
import com.itwill.steam.cart.Cart;
import com.itwill.steam.cart.CartService;
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
	@Autowired
	private CartService cartService;
	
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
	//카드정보 불러오기
	@RequestMapping(value = "/checkout-payment")
	public String checkoutCard(HttpServletRequest request) throws Exception {
		User loginUser =(User)request.getSession().getAttribute("loginUser");
		if(loginUser==null) {
			return "redirect:main";
		}
		Card card=cardService.findCardByNo(loginUser.getUNo());
		String[] exDateArray =  card.getCardExDate().split("/");//달,년도 분리
		String month = exDateArray[0];
		String year = exDateArray[1];
		
		request.setAttribute("card", card);
		request.setAttribute("month", month);//카드 날짜 불러오기
		request.setAttribute("year", year);//카드 년도 불러오기
		
		//card summery 
		List<Cart> orderItem = cartService.selectCart(loginUser.getUNo());
		request.setAttribute("orderItem", orderItem);
		
		  // 총액 계산
        int fullPrice = 0;
        int discountPrice = 0;
        int savedPrice = 0;
        int finalPrice = 0;
        for (Cart cart : orderItem) {
            fullPrice += cart.getGame().getGPrice();
            discountPrice=(int) (fullPrice*cart.getGame().getGDiscountRate()/100);
        }
        savedPrice=fullPrice-discountPrice;
        finalPrice=fullPrice-discountPrice;
        request.setAttribute("fullPrice", fullPrice);
        request.setAttribute("discountPrice", discountPrice);
        request.setAttribute("savedPrice", savedPrice);
        request.setAttribute("finalPrice", finalPrice);
		
		return "checkout-payment";
	}


	
	//주문생성
	@RequestMapping("/order_insert_action")
	public String order_insert_action(Order order,Model model,HttpSession session) {
		String forwardPath = "";
		User loginUser=(User) session.getAttribute("loginUser");
		try {
			orderService.insertOrder(order);
			model.addAttribute("successMessage","주문이 되었습니다.");
			model.addAttribute("order",order);
			forwardPath = "main";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "주문이 실패하였습니다.");
			forwardPath = "error";
		}
		return forwardPath;
	};
	
	//라이브러리로 정보 옮기기
}