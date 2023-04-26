package com.itwill.steam.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.card.Card;
import com.itwill.steam.card.CardService;
import com.itwill.steam.cart.Cart;
import com.itwill.steam.cart.CartService;
import com.itwill.steam.category.Category;
import com.itwill.steam.exception.ExistedLibraryException;
import com.itwill.steam.game.GameService;
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
	private final CartService cartService;
	private final OwnedGameService ownedGameService;
	private final GameService gameService;
	
	//카드정보 불러오기
	@RequestMapping(value = "/checkout-payment")
	public String checkoutCard(HttpServletRequest request, Model model) throws Exception {
		
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser==null) return "redirect:main";
		
		Card card=cardService.findCardByNo(loginUser.getUNo());
		String[] exDateArray = card.getCardExDate().split("/");//달,년도 분리
		String month = exDateArray[0];
		String year = exDateArray[1];
		
		request.setAttribute("card", card);
		request.setAttribute("month", month);//카드 날짜 불러오기
		request.setAttribute("year", year);//카드 년도 불러오기
		
		//orderitem summery
		List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
		model.addAttribute("cartList", cartList);
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Cart cart:cartList) {
			orderItemList.add(OrderItem.builder()
								.oiNo(cart.getCNo())
								.game(cart.getGame())
								.build()
								);
		}
		
		//총액 계산
        int fullPrice = 0;
        int savedPrice = 0;
        int finalPrice = 0;
        double fullDiscountPrice = 0;
        for (OrderItem orderItem : orderItemList) {
            fullPrice += orderItem.getGame().getGPrice();
            fullDiscountPrice += orderItem.getGame().getGPrice() * orderItem.getGame().getGDiscountRate() / 100;
        }
        int finalDiscountPrice = (int)fullDiscountPrice;
        
        savedPrice = finalDiscountPrice;
        finalPrice = fullPrice - finalDiscountPrice;
        request.setAttribute("fullPrice", fullPrice);
        request.setAttribute("finalDiscountPrice", finalDiscountPrice);
        request.setAttribute("savedPrice", savedPrice);
        request.setAttribute("finalPrice", finalPrice);
        
        //다음으로 전달하기 위해 order객체 세션에 저장 - 더 좋은 방법으로 수정할 예정
        Order order = Order.builder()
        		.oTotalPrice(finalPrice)
        		.uNo(loginUser.getUNo())
        		.orderItemList(orderItemList)
        		.build();
        request.getSession().setAttribute("order", order);
        
        /*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		int cartQuantity = cartService.countCart(loginUser.getUNo());
		model.addAttribute("cartQuantity", cartQuantity);
		/*************************************/
        
		return "checkout-payment";
	}

	//주문생성
	@PostMapping("/order-insert-action")
	public String orderInsertAction(Model model, HttpSession session) {
		
		Order order = (Order)session.getAttribute("order");
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null) return "redirect:main";
		
		/*****트랜잭션 시작*****/
		//주문 입력
		orderService.insertOrder(order);
		
		//라이브러리 입력
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNo", loginUser.getUNo());
		map.put("order", order);
		ownedGameService.insertOwnedGame(map);
		
		//카트 삭제
		cartService.deleteAllCarts(loginUser.getUNo());
		/*****트랜잭션 종료*****/
		
		return "redirect:main";
	};
	
	//ExistedLibraryException 발생 시 main으로 redirect
	@ExceptionHandler(ExistedLibraryException.class)
	public String existedLibraryExceptionHandler(ExistedLibraryException e) {
		return "redirect:main";
	}
}