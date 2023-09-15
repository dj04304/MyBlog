package com.jun.blogProject.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.jun.blogProject.dto.ResponseDto;

/*
 *  예외 controller
 *  @ControllerAdvice 어노테이션을 걸어놓으면 어떠한 exception 이 발생하면 이쪽 Controller로 오게끔 유도해준다.
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
