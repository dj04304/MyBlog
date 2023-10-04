package com.jun.blogProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// Bean에 등록
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
	
}
