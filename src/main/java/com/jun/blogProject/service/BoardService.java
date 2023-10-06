package com.jun.blogProject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.blogProject.model.Board;
import com.jun.blogProject.model.RoleType;
import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.BoardRepository;
import com.jun.blogProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// Bean에 등록
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional
	public void saveWrite(Board board, User user) { //title content
		board.setCount(0);
		board.setUserId(user);
		boardRepository.save(board);
	}
	
}
