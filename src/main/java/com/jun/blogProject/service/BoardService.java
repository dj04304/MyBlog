package com.jun.blogProject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.blogProject.model.Board;
import com.jun.blogProject.model.User;
import com.jun.blogProject.repository.BoardRepository;

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
	
	public Page<Board> writeList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board writeDetail(int id) {
		return boardRepository.findById(id)
					.orElseThrow(() -> {
						return new IllegalArgumentException("writeDetail is failed: Not Found ID.");
					});
	}
	
}
