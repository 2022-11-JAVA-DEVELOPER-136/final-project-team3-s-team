package com.itwill.steam.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.order.Order;
import com.itwill.steam.order.OrderService;
import com.itwill.steam.user.User;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	public CartController() {
		
	}
	
	/**로그인 첨가**/
	@RequestMapping(value = "/checkout-order", method = RequestMethod.GET)
	public String checkoutOrder(HttpSession session, Model model) {
	    try {
	        User loginUser = (User) session.getAttribute("loginUser");
	        if (loginUser == null) {
	            // 로그인하지 않은 사용자는 로그인 페이지로 리다이렉트
	            return "redirect:main";
	        }
	        List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
	        model.addAttribute("cartList", cartList);
	        model.addAttribute("loginUser", loginUser);
	        return "checkout-order";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";
	    }
	}

	@RequestMapping(value = "/checkout-order", method = RequestMethod.POST)
	public String checkoutAddress(HttpSession session, Model model, @RequestParam("orderNo") Order orderNo) {
	    try {
	        User loginUser = (User) session.getAttribute("loginUser");
	        if (loginUser == null) {
	            // 로그인하지 않은 사용자는 로그인 페이지로 리다이렉트
	            return "redirect:main";
	        }
	        int order = orderService.insertOrder(orderNo);
	        model.addAttribute("order", order);
	        return "checkout-address";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";
	    }
	}
	
	/*
	@RequestMapping(value = "/checkout-order", method = RequestMethod.GET)
	public String checkoutOrder(HttpSession session, Model model) {
	    User loginUser = (User) session.getAttribute("loginUser");
	    if (loginUser != null) {
	        List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
	        model.addAttribute("cartList", cartList);
	    }
	    return "checkout-order";
	}
	
	@RequestMapping(value = "/checkout-order-address", method = RequestMethod.POST)
	public String checkoutAddress(Model model, @RequestParam("orderNo") Order orderNo) {
	    int order = orderService.insertOrder(orderNo);
	    model.addAttribute("order", order);
	    return "checkout-address";
	}
	 */

		
		//조까치 아무 것도 안될 때 대비용 비상구
//		@RequestMapping("/checkout-order")
//		public String checkout_order() {
//			return "checkout-order";
//		}
		
		
}
