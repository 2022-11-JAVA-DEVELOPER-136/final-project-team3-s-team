package com.itwill.steam.cart;

import java.util.List;

public interface CartDao {
	
	//상품 추가
	public int insertCart(Cart cart);
	
	//상품 보여주기
	public List<Cart> selectCart(int cNo);
	
	//상품 삭제
	public int deleteCart(int cNo);
	
	//상품 전체 삭제
	public int deleteAllCarts(int cNo);
	
	
}
