package com.itwill.steam.wishList.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.wishList.WishList;

@Mapper
public interface WishListMapper {
	
	//상품 추가
	public int insertWishList(WishList wishList);
	
	//상품 선택
	public List<WishList> selectWishList(int uNo);
	
	//상품 삭제
	public int deleteWishList(int wishNo);
	
	//상품 전체 삭제
	public int deleteAllWishLists(int uNo);
}