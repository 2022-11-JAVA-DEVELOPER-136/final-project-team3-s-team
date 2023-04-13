package com.itwill.steam.exception;

//GameController에서 사용
public class GameNotFoundException extends RuntimeException {
	public GameNotFoundException(String msg) {
		super(msg);
	}
}