package com.itwill.steam.cart;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.steam.category.Category;
import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameService;
import com.itwill.steam.order.Order;
import com.itwill.steam.order.OrderService;
import com.itwill.steam.user.User;
import com.itwill.steam.wishList.WishList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CartController {
	
	private final CartService cartService;
	private final GameService gameService;
	
	//checkout-order 페이지로 이동
	@RequestMapping(value = "/checkout-order")
	public String checkoutOrder(HttpSession session, Model model) {
		
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser==null) return "redirect:main";
        
        List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
        model.addAttribute("cartList", cartList);
        
        //총액 계산
        int fullPrice = 0;
        int savedPrice = 0;
        int finalPrice = 0;
        double fullDiscountPrice = 0;
        for (Cart cart : cartList) {
            fullPrice += cart.getGame().getGPrice();
            fullDiscountPrice += cart.getGame().getGPrice() * cart.getGame().getGDiscountRate() / 100;
        }
        int finalDiscountPrice = (int)fullDiscountPrice;
        
        savedPrice = finalDiscountPrice;
        finalPrice = fullPrice - finalDiscountPrice;
        model.addAttribute("fullPrice", fullPrice);
        model.addAttribute("finalDiscountPrice", finalDiscountPrice);
        model.addAttribute("savedPrice", savedPrice);
        model.addAttribute("finalPrice", finalPrice);
        
        /*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		int cartQuantity = cartService.countCart(loginUser.getUNo());
		model.addAttribute("cartQuantity", cartQuantity);
		/*************************************/
        
        return "checkout-order";
	}

	//checkout-address 페이지로 이동
	@RequestMapping(value = "/checkout-address")
	public String checkoutAddress(HttpSession session, Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null) return "redirect:main";
		
		List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
		model.addAttribute("cartList", cartList);
		model.addAttribute("loginUser", loginUser);
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		int cartQuantity = cartService.countCart(loginUser.getUNo());
		model.addAttribute("cartQuantity", cartQuantity);
		/*************************************/
		
		return "checkout-address";
	}
	
	//장바구니에 상품 추가
	@PostMapping(value = "/insert-cart")
	public String insertCart(@RequestParam String uNo, @RequestParam String gNo, RedirectAttributes redirectAttributes) {
		
    	Cart cart = Cart.builder()
    				.user(User.builder().uNo(Integer.parseInt(uNo)).build())
    				.game(Game.builder().gNo(Integer.parseInt(gNo)).build())
    				.build();
        cartService.insertCart(cart);
        redirectAttributes.addAttribute("gNo", gNo);
        
        return "redirect:store-product";
	}
	
	//장바구니에 담긴 상품 삭제
	@PostMapping(value = "/delete-cart")
	public String deleteCart(@RequestParam String cNo, HttpSession session) {
		
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser==null) return "redirect:main";
        
        cartService.deleteCart(Integer.parseInt(cNo));
        
        return "redirect:checkout-order";
	}
}