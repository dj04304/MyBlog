package com.jun.blogProject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.blogProject.model.RoleType;
import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// Bean에 등록
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public void save(User user) {
		String rawPassword = user.getPassword(); //원래 비밀번호
		String encPassword = passwordEncoder.encode(rawPassword); // 암호화
		
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
}
