package com.itwill.steam.wishList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private WishListDao wishListDao;
	
	//상품 추가
	@Override
	public int insertWishList(WishList wishList) {
		return wishListDao.insertWishList(wishList);
	}
	
	//상품 선택
	@Override
	public List<WishList> selectWishList(int uNo) {
		return wishListDao.selectWishList(uNo);
	}
	
	//상품 삭제
	@Override
	public int deleteWishList(int wishNo) {
		return wishListDao.deleteWishList(wishNo);
	}
	
	//상품 전체 삭제
	@Override
	public int deleteAllWishLists(int uNo) {
		return wishListDao.deleteAllWishLists(uNo);
	}

}