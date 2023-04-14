package com.itwill.steam.user;

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
			userService.login(user.getUId(), user.getUPassword());
			session.setAttribute("sUserId", user.getUId());
			forwardPath="profile";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="profile";
		}catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="profile";
		}
		return forwardPath;
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
