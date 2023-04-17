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

import com.itwill.steam.exception.ExistedUserException;
import com.itwill.steam.exception.PasswordMissmatchException;
import com.itwill.steam.exception.UserNotFoundException;
import com.itwill.steam.friend.Friend;
import com.itwill.steam.game.GameService;
import com.itwill.steam.review.Review;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping("/user_write")
	public String user_write_form() {
		String forward_path = "user_write";
		return forward_path;
	}
	
	@PostMapping("user_write_action")
	public String user_write_action(@ModelAttribute("fuser") User user,Model model){
		String forward_path = "";
		try {
			userService.create(user);
			forward_path="redirect:main";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			forward_path="user_write";
		}
		return forward_path;
	}
	@GetMapping(value = "/user_login")
	public String user_main() {
		return "user_login";
	}
	@PostMapping("/user_login_action")
	public String user_login_action(@ModelAttribute("fuser") User user,Model model,HttpSession session) {
		
		String forwardPath = "";
		try {
			User loginUser =userService.login(user.getUId(), user.getUPassword());
			session.setAttribute("loginUser", loginUser);
			forwardPath="main";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="main";
		}catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="main";
		}
		return forwardPath;
	}
	@GetMapping(value = "/profile")
	public String profile(Model model,HttpSession session, HttpServletRequest request) {
		// 세션 정보
		User loginUser = (User) session.getAttribute("loginUser");
		
		
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
		
		// 리뷰조회
		List<Review> reviewList = loginUser.getReviewList();
		System.out.println("리뷰::"+reviewList);
		request.setAttribute("reviewList", reviewList);
		
		// Comments 조회
		
		// game 조회
		return "profile";
	}
	@LoginCheck
	@GetMapping("/user_view")
	public String user_view(HttpServletRequest request) {
		String forwardPath = "";
		String sUserId =(String)request.getSession().getAttribute("sUserId");
		User loginUser=userService.findUserById(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath="user_view";
		
		return forwardPath;
	}
	@LoginCheck
	@PostMapping("user_modify")
	public String user_modify_form(HttpServletRequest request) {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		User loginUser=userService.findUserById(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath="user_modify";
		
		return forwardPath;
	}
	@LoginCheck
	@PostMapping("/user_modify_action")
	public String user_modify_action(@ModelAttribute User user,HttpServletRequest request) {
		String forwardPath = "";
		userService.update(user);
		forwardPath="redirect:user_view";
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
