package com.itwill.steam.exception;

//위시리스트 서비스에서 사용
public class ExistedWishListException extends RuntimeException{
	public ExistedWishListException(String msg) {
		super(msg);
	}
}
