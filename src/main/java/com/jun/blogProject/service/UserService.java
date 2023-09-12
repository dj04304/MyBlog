package com.jun.blogProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

// Bean에 등록
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public int save(User user) {
	
		try {
			userRepository.save(user);
			System.out.println(userRepository.save(user));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService: " + e.getMessage());
		}
		
		return -1;
		
	}
}
