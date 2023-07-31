package com.jun.blogProject.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스프링이 특정 어노테이션이 붙어있는 클래스 파일을 new(IoC)해서 스프링 컨테이너에 관리해줍니다.
public class BlogControllerTest {

	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello test<h1>";
	}
	
	@PostMapping("/test")
	public String test() {
		return "test";
	}
}
