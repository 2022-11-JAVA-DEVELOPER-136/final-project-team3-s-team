package com.itwill.steam.wishList;

import java.util.List;
import java.util.Map;

public interface WishListDao {
	
	//상품 추가
	public int insertWishList(WishList wishList);
	
	//위시리스트에 해당 게임이 있는지 확인여부
	public int existWishList(Map<String, Object> map);
	
	//상품 보여주기
	public List<WishList> selectWishList(int uNo);
	
	//상품 삭제
	public int deleteWishList(int wishNo);
	
	//상품 전체 삭제
	public int deleteAllWishLists(int uNo);
}