package com.itwill.steam.exception;

public class ExistedUserException extends RuntimeException{
	public ExistedUserException(String msg) {
		super(msg);
	}
}
