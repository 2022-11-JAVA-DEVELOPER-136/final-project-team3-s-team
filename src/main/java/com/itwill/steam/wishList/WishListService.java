package com.itwill.steam.wishList;

import java.util.List;
import java.util.Map;

public interface WishListService {
	
	//상품 추가
	public int insertWishList(WishList wishList);
	
	//상품 선택
	public List<WishList> selectWishList(int uNo);
	
	//상품 삭제
	public int deleteWishList(int wishNo);
	
	//상품 전체 삭제
	public int deleteAllWishLists(int uNo);
	
}