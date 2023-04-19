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

import com.itwill.steam.game.Game;
import com.itwill.steam.game.GameService;
import com.itwill.steam.order.Order;
import com.itwill.steam.order.OrderService;
import com.itwill.steam.user.User;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GameService gameService;
	
	public CartController() {
		
	}
	
		// checkout-order 페이지로 이동
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
		
		// checkout-address 페이지로 이동
		@RequestMapping(value = "/checkout-address", method = RequestMethod.GET)
		public String checkoutAddress(HttpSession session, Model model) {
			User loginUser = (User) session.getAttribute("loginUser");
			List<Cart> cartList = cartService.selectCart(loginUser.getUNo());
			model.addAttribute("cartList", cartList);
			model.addAttribute("loginUser", loginUser);
			return "checkout-address";
		}
		
		// 상품 불러오기
		@RequestMapping(value = "/selectcart", method = RequestMethod.GET)
		public String selectCart(@RequestParam("game") int cNo, Model model) {
			try {
				List<Cart> game = cartService.selectCart(cNo);
				model.addAttribute("game", game);
				return "selectcart";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		// 장바구니에 담긴 상품 삭제
		@RequestMapping(value = "/deletecart", method = RequestMethod.GET)
		public String deleteCart(@RequestParam("cNo") int cNo, HttpSession session) {
		    try {
		        User loginUser = (User) session.getAttribute("loginUser");
		        if (loginUser != null) {
		            cartService.deleteCart(loginUser.getUNo());
		        }
		        return "redirect:checkout-order";
		    } catch (Exception e) {
		        e.printStackTrace();
		        return "error";
		    }
		}

		//조까치 아무 것도 안될 때 대비용 비상구
//		@RequestMapping("/checkout-order")
//		public String checkout_order() {
//			return "checkout-order";
//		}
		
		
}
