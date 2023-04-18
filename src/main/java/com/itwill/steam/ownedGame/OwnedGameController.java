package com.itwill.steam.ownedGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.steam.game.Game;
import com.itwill.steam.gameTag.GameTag;

public class OwnedGameController {
	
	@Autowired
	private OwnedGameService ownedGameService;
	
	public OwnedGameController() {
	}
	
    @RequestMapping(value = "/store-library", params = "uNo")
    public List<OwnedGame> getOwnedGameList(@RequestParam int uNo) {
        return ownedGameService.ownedGameList(uNo);
    }
	
}