package com.itwill.steam.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.cart.mapper.CartMapper;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private CartMapper CartMapper;
	
	//상품 추가
	@Override
	public int insertCart(Cart cart) {
		return CartMapper.insertCart(cart);	
	}
	
	//상품 선택
	@Override
	public List<Cart> selectCart(int uNo) {
		return CartMapper.selectCart(uNo);	
	}
	
	//상품 삭제
	@Override
	public int deleteCart(int cNo) {
		return CartMapper.deleteCart(cNo);
	}
	
	//상품 전체 삭제
	@Override
	public int deleteAllCarts(int uNo) {
		return CartMapper.deleteAllCarts(uNo);
	}

	//유저의 카트에 담긴 품목 수 반환
	@Override
	public int countCart(int uNo) {
		return CartMapper.countCart(uNo);
	}
}