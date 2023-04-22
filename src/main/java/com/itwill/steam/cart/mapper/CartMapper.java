package com.itwill.steam.cart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.cart.Cart;

@Mapper
public interface CartMapper {
	
	//상품 추가
	public int insertCart(Cart cart);
	
	//상품 선택
	public List<Cart> selectCart(int uNo);
	
	//상품 삭제
	public int deleteCart(int cNo);
	
	//상품 전체 삭제
	public int deleteAllCarts(int uNo);
	
	//유저의 카트에 담긴 품목 수 반환
	public int countCart(int uNo);
}