package com.itwill.steam.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.cart.mapper.CartMapper;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private CartMapper CartMapper;
	
	@Override
	public int insertCart(Cart cart) {
		return CartMapper.insertCart(cart);	
	}

	@Override
	public int selectCart(int cNo) {
		return 0;
	}
	
	@Override
	public List<Cart> selectAllCarts(int cNo) {
		return CartMapper.selectAllCart(cNo);
		
	}

	@Override
	public int deleteCart(int cNo) {
		return 0;
	}
	
	@Override
	public List<Cart> deleteAllCarts(int cNo) {
		return CartMapper.deleteAllCart(cNo);
	}

}
