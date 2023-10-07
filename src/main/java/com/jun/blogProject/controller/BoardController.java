package com.jun.blogProject.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jun.blogProject.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping({"", "/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) { 
		model.addAttribute("boards", boardService.writeList(pageable)); // model 에 데이터를 담으면 view까지 데이터를 끌고간다.
		
//		System.out.println("User ID: " + principal.getUsername());
		return "index"; // 일반 Controller 기 때문에 viewResolver 작동이된다.
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
