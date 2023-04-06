package com.itwill.steam.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public int insertCart(Cart cart) {
		return cartDao.insertCart(cart);
	}

	@Override
	public List<Cart> selectCart(int uNo) {
		return cartDao.selectCart(uNo);
	}

	@Override
	public int deleteCart(int cNo) {
		return cartDao.deleteCart(cNo);
	}

	@Override
	public int deleteAllCarts(int uNo) {
		return cartDao.deleteAllCarts(uNo);
	}

}
