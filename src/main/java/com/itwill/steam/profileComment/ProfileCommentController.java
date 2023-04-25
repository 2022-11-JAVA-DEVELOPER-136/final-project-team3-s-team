package com.itwill.steam.profileComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.user.User;

@Controller
public class ProfileCommentController {
	@Autowired
	private ProfileCommentService profileCommentService;
	
	@PostMapping("/insert-profile-comment")
    public String insertProfileComment(ProfileComment profileComment) {
        profileCommentService.insertProfileComment(profileComment);
        return "redirect:profile";
    }
	
	@PostMapping("/update-profile-comment")
    public String updateProfileComment(ProfileComment profileComment) {
        profileCommentService.updateProfileComment(profileComment);     
        return "redirect:profile";
        
    }
	
	@GetMapping("/delete-profile-comment")
    public String deleteProfileComment(@RequestParam("pcNo") int pcNo) {
        profileCommentService.deleteProfileComment(pcNo);
        return "redirect:profile";
    }
	
	@GetMapping("/list-profile-comment")
	   public String SelectByProfileUserNo(User profileUser, Model model) {
	       List<ProfileComment> profileComments = profileCommentService.selectByProfileUserNo(profileUser);
	       model.addAttribute("profileComments", profileComments);
	       return "profileComments";
	   }
	 
}
