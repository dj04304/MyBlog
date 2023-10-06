package com.jun.blogProject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jun.blogProject.config.auth.PrincipalDetail;

@Controller
public class BoardController {

	@GetMapping({"", "/"})
	public String index() { //세션에 접근하는 방법 @AuthenticationPrincipal PrincipalDetail principal
		
//		System.out.println("User ID: " + principal.getUsername());
		return "index";
	}
}
