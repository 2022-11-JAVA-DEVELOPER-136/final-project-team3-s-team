package com.itwill.steam.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Global Exception Controller - 모든 컨트롤러의 공통 예외 처리
 */
@ControllerAdvice
public class GlobalExceptionController {
	
	//따로 처리하는 특정 예외를 제외한, 모든 예외를 처리
	@ExceptionHandler(Exception.class)
	public String commonExceptionHandler(Exception e) {
		e.printStackTrace();
		return "steam_error";
	}
	
	//특정 예외를 처리 - RuntimeException
	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionHandler(Exception e) {
		e.printStackTrace();
		return "steam_error";
	}
}