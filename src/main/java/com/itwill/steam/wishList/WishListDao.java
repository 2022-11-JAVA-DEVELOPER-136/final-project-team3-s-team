package com.itwill.steam.wishList;

import java.util.List;

public interface WishListDao {
	
	//상품 추가
	public int insertWishList(WishList wishList);
	
	//상품 보여주기
	public List<WishList> selectWishList(int cNo);
	
	//상품 삭제
	public int deleteWishList(int cNo);
	
	//상품 전체 삭제
	public int deleteAllWishLists(int cNo);
}
