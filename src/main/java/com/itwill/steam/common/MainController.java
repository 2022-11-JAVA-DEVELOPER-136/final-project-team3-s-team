package com.itwill.steam.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	//메인화면
	@RequestMapping("/steam_main")
	public String steamMain() {
		return "steam_main";
	}
	
	//root
	@GetMapping("/")
	public String welcome() {
		return "redirect:steam_main";
	}
	
	//POST방식으로 요청해야 하는 method에 GET방식으로 요청하는 경우, steam_main으로 redirect
	//@GetMapping({})
	public String steamGet() {
		return "redirect:steam_main";
	}
	
	/***************************** template test start *****************************/
	@RequestMapping("/404")
	public String fileNotFoundError() {
		return "404";
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	//@RequestMapping("/checkout-address")
	public String checkoutAddress() {
		return "checkout-address";
	}
	//@RequestMapping("/checkout-order")
	public String checkoutOrder() {
		return "checkout-order";
	}
	//@RequestMapping("/checkout-payment")
	public String checkoutPayment() {
		return "checkout-payment";
	}
	@RequestMapping("/coming_soon")
	public String comingSoon() {
		return "coming_soon";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("/forum")
	public String forum() {
		return "forum";
	}
	@RequestMapping("/forum-topic")
	public String forumTopic() {
		return "forum-topic";
	}
	@RequestMapping("/help-center")
	public String helpCenter() {
		return "help-center";
	}
	@RequestMapping("/help-center-article")
	public String helpCenterArticle() {
		return "help-center-article";
	}
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	@RequestMapping("/news")
	public String news() {
		return "news";
	}
	@RequestMapping("/news-article")
	public String newsArticle() {
		return "news-article";
	}
	@RequestMapping("/one-page")
	public String onePage() {
		return "one-page";
	}
	@RequestMapping("/private-messaging")
	public String privateMessaging() {
		return "private-messaging";
	}
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}
	//@RequestMapping("/store")
	public String store() {
		return "store";
	}
	//@RequestMapping("/store-product")
	public String storeProduct() {
		return "store-product";
	}
	/****************************** template test end ******************************/
}