package com.jun.blogProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping({"", "/"})
	public String index() { //세션에 접근하는 방법 @AuthenticationPrincipal PrincipalDetail principal
		
//		System.out.println("User ID: " + principal.getUsername());
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
