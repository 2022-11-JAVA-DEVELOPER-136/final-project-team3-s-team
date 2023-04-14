package com.itwill.steam.exception;

public class PasswordMissmatchException extends RuntimeException {
	public PasswordMissmatchException(String msg) {
		super(msg);
	}
}
