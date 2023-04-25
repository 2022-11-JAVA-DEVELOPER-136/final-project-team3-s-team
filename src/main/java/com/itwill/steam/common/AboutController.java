package com.itwill.steam.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AboutController {
	
	
	
	@RequestMapping("/about")
	public String about() {
		
		
		
		return "about";
	}
}