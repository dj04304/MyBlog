package com.jun.blogProject.test;

import java.util.function.Supplier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.blogProject.model.RoleType;
import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DummyController {
	
	private final UserRepository userRepository;

	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id:" + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("time: " +user.getCreateDate());
		
		user.setRole(RoleType.USER);
		
		userRepository.save(user);
		return "회원가입 완료";
	}
	
	// id 주소로 파라미터를 전달받을 수 있다.
	
	//user 객체가 존재한다면 id를 통해 가져오면 되지만, 존재하지 않는 id는 존재하지 않는다고 사용자에게 오류를 전달해줘야한다.
	//그래서 optioanl 에서 orElseThrow, orElseGet등 여러가지를 가지고 있는데 orElseThrow 를 통해 Supplier 인터페이스를 new하여 익명클래스를 생성한 후 
	//IllegalArgumentException 을 return하여 해당 id는 존재하지 않는다는 것을 전달해줄 수 있다.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				
//				return new IllegalArgumentException("해당 사용자는 존재하지 않습니다. id: " + id);
//			}
//		});
		
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 사용자는 존재하지 않습니다. id: " + id);
		});
		
		//의문: user객체가 java object인데 웹 브라우저에 요청했을 때 응답을 받을 수 있는 이유
		// 이는 웹 브라우저가 이해할 수 있는 (대표적으로 JSON) 파일로 변환해서 전달해주는 것이 일반적이다.
		// 스프링부트에서는 MessageConverter가 응답시에 자동으로 작동하여 JavaObject를 return하게 될 경우 Jackson라이브러리를 호출하여 json으로 변환 후 웹 브라우저에게 전달하게 된다.
		return user;
	}
	
}
