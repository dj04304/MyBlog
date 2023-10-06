package com.jun.blogProject.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.blogProject.config.auth.PrincipalDetail;
import com.jun.blogProject.dto.ResponseDto;
import com.jun.blogProject.model.Board;
import com.jun.blogProject.model.RoleType;
import com.jun.blogProject.model.User;
import com.jun.blogProject.service.BoardService;
import com.jun.blogProject.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		
		boardService.saveWrite(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
