package com.itwill.steam.exception;

//OwnedService에서 사용
public class ExistedLibraryException extends RuntimeException {
	public ExistedLibraryException(String msg) {
		super(msg);
	}
}