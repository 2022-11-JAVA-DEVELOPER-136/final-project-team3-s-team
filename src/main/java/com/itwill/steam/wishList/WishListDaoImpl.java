package com.itwill.steam.wishList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.wishList.mapper.WishListMapper;

@Repository
public class WishListDaoImpl implements WishListDao {
	
	@Autowired
	private WishListMapper WishListMapper;
	
	//상품 추가
	@Override
	public int insertWishList(WishList wishList) {
		return WishListMapper.insertWishList(wishList);
	}
	
	//상품 선택
	@Override
	public List<WishList> selectWishListByUserNo(int uNo) {
		return WishListMapper.selectWishListByUserNo(uNo);
	}
	
	//상품 삭제
	@Override
	public int deleteWishList(int wishNo) {
		return WishListMapper.deleteWishList(wishNo);
	}
	
	//상품 전체 삭제
	@Override
	public int deleteAllWishLists(int uNo) {
		return WishListMapper.deleteAllWishLists(uNo);
	}

}