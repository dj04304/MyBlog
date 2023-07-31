package com.jun.blogProject.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {

	@GetMapping("/http/get")
	public String getHttp(Member m) { //?id=1&username=jun&password=1234&email=dj04304@naver.com
		return "get 요청: " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postHttp(@RequestBody Member m) { //MessageConverter(스프링부트) 자동으로 parssing 해줌
		return "post 요청: " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putHttp(@RequestBody Member m) {
		return "put 요청: " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteHttp() {
		return "delete 요청";
	}
}
