package com.itwill.steam.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.steam.card.CardService;
import com.itwill.steam.cart.CartService;
import com.itwill.steam.category.Category;
import com.itwill.steam.exception.ExistedUserException;
import com.itwill.steam.exception.PasswordMissmatchException;
import com.itwill.steam.exception.UserNotFoundException;
import com.itwill.steam.friend.Friend;
import com.itwill.steam.game.GameService;
import com.itwill.steam.review.Review;
import com.itwill.steam.review.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	private final UserService userService;
	private final GameService gameService;
	private final CartService cartService;
	private final ReviewService reviewService;
	private final CardService cardService;
	
	@RequestMapping("/user_write")
	public String user_write_form() {
		String forward_path = "user_write";
		return forward_path;
	}
	
	@PostMapping("/user_write_action")
	public String user_write_action(@ModelAttribute("fuser") User user, Model model){
		String forwardPath = "";
		
		try {
			userService.create(user);
			model.addAttribute("succYn", "Y");
			forwardPath = "main";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("succYn", "N");
			forwardPath = "main";
		}
		
		return forwardPath;
	}
	
	@RequestMapping(value = "/common-sign-up")
	public String user_main() {
		return "common-sign-up";
	}
	
	@PostMapping("/user_login_action")
	public String user_login_action(@ModelAttribute("fuser") User user, Model model, HttpSession session) {
		
		String forwardPath = "";
		try {
			User loginUser =userService.login(user.getUId(), user.getUPassword());
			session.setAttribute("loginUser", loginUser);
			model.addAttribute("loginSuccYn", "Y");
			forwardPath="main";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			model.addAttribute("loginSuccYn", "N");
			forwardPath="main";
		}catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			model.addAttribute("loginSuccYn", "N");
			forwardPath="main";
		}
		return forwardPath;
	}
	@LoginCheck
	@GetMapping(value = "/profile")
	public String profile(Model model,HttpSession session, HttpServletRequest request) {
		// 세션 정보
		User loginUser = (User) session.getAttribute("loginUser");
		
//		cardService.findCardByNo(loginUser.getUNo());
		if (loginUser == null) {
			return "redirect:main";
		}
		System.out.println("로긴유저::"+loginUser);
		
		// 친구 리스트조회
		User fUser = new User();
		
		List<User> fUserList = new ArrayList<User>();
		int fCnt = loginUser.getFriendList().size();	// 친구수
		
		for(Friend friend : loginUser.getFriendList()) {
			fUser = userService.findUserByNo(friend.getUFNo());	// 친구 번호
			fUserList.add(fUser);
		}
		request.setAttribute("fUserList", fUserList);
		request.setAttribute("onCnt", fCnt);	// 온라인 친구수
		request.setAttribute("offCnt", fCnt);	// 오프라인 친구수
		
		// TODO 리뷰조회 from 리뷰서비스
//		List<Review> reveiwList1 = reviewService.selectByUserNo(loginUser);
//		System.out.println("리뷰::"+reveiwList1);
		
		// 리뷰조회 from user
		List<Review> reviewList = loginUser.getReviewList();
		System.out.println("리뷰::"+reviewList);
		request.setAttribute("reviewList", reviewList);
		
		// Comments 조회
		
		// game 조회
		
		/*****common-navbar.html에서 사용*****/
        List<Category> categoryList = gameService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		int cartQuantity = cartService.countCart(loginUser.getUNo());
		model.addAttribute("cartQuantity", cartQuantity);
		/*************************************/
		
		return "profile";
	}
//	@LoginCheck
//	@GetMapping("/user_view")
//	public String user_view(HttpServletRequest request) {
//		String forwardPath = "";
//		String sUserId =(String)request.getSession().getAttribute("sUserId");
//		User loginUser=userService.findUserById(sUserId);
//		request.setAttribute("loginUser", loginUser);
//		forwardPath="user_view";
//		
//		return forwardPath;
//	}
//	@LoginCheck
//	@PostMapping("user_modify")
//	public String user_modify_form(HttpServletRequest request) {
//		String forwardPath = "";
//		String sUserId=(String)request.getSession().getAttribute("sUserId");
//		User loginUser=userService.findUserById(sUserId);
//		request.setAttribute("loginUser", loginUser);
//		forwardPath="user_modify";
//		
//		return forwardPath;
//	}
	@LoginCheck
	@PostMapping("/user_modify_action")
	public String user_modify_action(@ModelAttribute User user,Model model,HttpServletRequest request) {
		String forwardPath = "";
		try {

			userService.update(user);
			
			User loginUser = userService.findUserByNo(user.getUNo());
			request.getSession().setAttribute("loginUser", loginUser);
			model.addAttribute("succYn", "Y");
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg1",e.getMessage());
			model.addAttribute("succYn", "N");
		}
		
		
		
		//forwardPath="redirect:user_view";
		forwardPath="profile";
		return forwardPath;
	}
	@LoginCheck
	@PostMapping("/user_remove_action")
	public String user_remove_action(HttpServletRequest request) {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		User user =userService.findUserById(sUserId);
		userService.remove(user.getUNo());
		request.getSession().invalidate();
		
		forwardPath="redirect:main";
		return forwardPath;
	}
	@LoginCheck
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		request.getSession(false).invalidate();
		forwardPath="redirect:main";
		
		return forwardPath;
	}
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
				"user_write_action",
				"user_login_action",
				"user_modify",
				"user_modify_action",
				"user_remove_action"
				})
	public String user_get() {
		String forwardPath = "redirect:main";
		return forwardPath;
	}
	/****************Local Exception Handler***********/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "steam_error";
	}
}