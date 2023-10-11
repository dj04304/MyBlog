package com.jun.blogProject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.blogProject.config.auth.PrincipalDetail;
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
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> writeList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board writeDetail(int id) {
		return boardRepository.findById(id)
					.orElseThrow(() -> {
						return new IllegalArgumentException("writeDetail is failed: Not Found ID.");
					});
	}
	
	@Transactional
	public void deleteById(int id, PrincipalDetail principal) {
		
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> {
					return new IllegalArgumentException("writeDetail is failed: Not Found ID.");
				}
				
						);
		
		if(board.getUser().getId() != principal.getUser().getId()) {
			throw new IllegalArgumentException("Delete  failed: You do not have permission to delete.");
		}
		
		boardRepository.deleteById(id);
	}
	
}
