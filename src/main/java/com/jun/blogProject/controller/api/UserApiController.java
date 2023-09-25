package com.jun.blogProject.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.blogProject.dto.ResponseDto;
import com.jun.blogProject.model.RoleType;
import com.jun.blogProject.model.User;
import com.jun.blogProject.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {
	
	private final UserService userService;
	
	private final HttpSession session;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save");
		user.setRole(RoleType.USER); // role 만 강제로 넣어줌
		userService.save(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//일반적인 로그인(시큐리티 사용 x)
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user) {
		System.out.println("UserApiController: login");
		User principal = userService.login(user); //principal == 접근 주체
		
		if(principal != null) {
			session.setAttribute("principal", principal); // principal 이 있다면, 세션에 담아준다.
		}
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
