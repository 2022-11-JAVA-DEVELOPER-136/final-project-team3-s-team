package com.itwill.steam.ownedGame;
	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.user.User;

	
@Controller
public class OwnedGameController {
	
	@Autowired
	private OwnedGameService ownedGameService;
	
	public OwnedGameController() {
	}
	
    @RequestMapping(value = "/store-library", params = "uNo")
    public String getOwnedGameList(@RequestParam User user, Model model) {
    	
    	List<OwnedGame> ownedGameList = ownedGameService.ownedGameList(user);
    	model.addAttribute("ownedGameList", ownedGameList);
        
        return "store-library";
    }
	
}	