package com.itwill.steam.cart;

import java.util.List;

public interface CartDao {
	
	//상품 추가
	public int insertCart(Cart cart);
	
	//상품 선택
	public List<Cart> selectCart(int uNo);
	
	//상품 삭제
	public int deleteCart(int cNo);
	
	//상품 전체 삭제
	public int deleteAllCarts(int cNo);
	
	//유저의 카트에 담긴 품목 수 반환
	public int countCart(int uNo);
}