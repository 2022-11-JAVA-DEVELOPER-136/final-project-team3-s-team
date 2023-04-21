package com.itwill.steam.wishList.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.wishList.WishList;

@Mapper
public interface WishListMapper {
	
	//상품 추가
	public int insertWishList(WishList wishList);
	
	//유저번호로 해당 유저 위시리스트 보여주기
	public List<WishList> selectWishListByUserNo(int uNo);
	
	//상품 삭제
	public int deleteWishList(int wishNo);
	
	//상품 전체 삭제
	public int deleteAllWishLists(int uNo);
}