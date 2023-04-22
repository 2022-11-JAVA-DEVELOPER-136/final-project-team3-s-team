package com.itwill.steam.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	//상품 추가
	@Override
	public int insertCart(Cart cart) {
		return cartDao.insertCart(cart);
	}
	
	//상품 선택
	@Override
	public List<Cart> selectCart(int uNo) {
		return cartDao.selectCart(uNo);
	}
	
	//상품 삭제
	@Override
	public int deleteCart(int cNo) {
		return cartDao.deleteCart(cNo);
	}
	
	//상품 전체 삭제
	@Override
	public int deleteAllCarts(int uNo) {
		return cartDao.deleteAllCarts(uNo);
	}

	//유저의 카트에 담긴 품목 수 반환
	@Override
	public int countCart(int uNo) {
		return cartDao.countCart(uNo);
	}
}