package com.itwill.steam.cart;

import java.util.List;

public interface CartDao {
	
	//상품 추가
	public int insertCart(Cart cart);
	
	//상품 선택
	public int selectCart(int cNo);
	
	//상품 전체 선택
	public List<Cart> selectAllCarts(int cNo);
	
	//상품 삭제
	public int deleteCart(int cNo);
	
	//상품 전체 삭제
	public List<Cart> deleteAllCarts(int cNo);
	
	
}
