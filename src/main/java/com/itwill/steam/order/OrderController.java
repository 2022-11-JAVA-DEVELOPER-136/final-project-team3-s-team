package com.itwill.steam.order;

import java.util.ArrayList;
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
import com.itwill.steam.orderItem.OrderItem;
import com.itwill.steam.ownedGame.OwnedGameService;
import com.itwill.steam.user.LoginCheck;
import com.itwill.steam.user.User;
import com.itwill.steam.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {
	
	private final OrderService orderService;
	private final CardService cardService;
	private final UserService userService;
	private final CartService cartService;
	private final OwnedGameService ownedGameService;
	
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
		
		//orderitem summery
		List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Cart cart:cartList) {
			orderItemList.add(OrderItem.builder()
								.oiNo(cart.getCNo())
								.uNo(cart.getUser().getUNo())
								.game(cart.getGame())
								.build()
								);
		}
		
		// 총액 계산
        int fullPrice = 0;
        int discountPrice = 0;
        int savedPrice = 0;
        int finalPrice = 0;
        for (OrderItem orderItem : orderItemList) {
            fullPrice += orderItem.getGame().getGPrice();
            discountPrice=(int) (fullPrice*orderItem.getGame().getGDiscountRate()/100);
        }
        savedPrice=fullPrice-discountPrice;
        finalPrice=fullPrice-discountPrice;
        request.setAttribute("fullPrice", fullPrice);
        request.setAttribute("discountPrice", discountPrice);
        request.setAttribute("savedPrice", savedPrice);
        request.setAttribute("finalPrice", finalPrice);
        
        //다음으로 전달하기 위해 order객체 세션에 저장 - 더 좋은 방법으로 수정할 예정
        Order order = Order.builder()
        		.oTotalPrice(finalPrice)
        		.uNo(loginUser.getUNo())
        		.orderItemList(orderItemList)
        		.build();
        request.getSession().setAttribute("order", order);
        
		return "checkout-payment";
	}


	
	//주문생성
	@RequestMapping("/order_insert_action")
	public String orderInsertAction(Model model,HttpSession session) {
		String forwardPath = "";
		
		Order order = (Order)session.getAttribute("order");
		
		User loginUser=(User) session.getAttribute("loginUser");
		try {
			orderService.insertOrder(order);
			cartService.deleteAllCarts(loginUser.getUNo());
			//ownedGameService의 라이브러리 추가 메소드 사용해서 추가 해야 함. - 메소드 생기면 할 것
			
			forwardPath = "redirect:main";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "주문이 실패하였습니다.");
			forwardPath = "error";
		}
		return forwardPath;
	};
	
	//라이브러리로 정보 옮기기
}