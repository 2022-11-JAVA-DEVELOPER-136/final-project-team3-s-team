package com.itwill.steam.review;

import java.util.List;

public interface ReviewDao {
	
	//게임 리뷰 작성
	public int insertGameReview(Review review);
		
	//게임 리뷰 삭제
	public int deleteGameReview(int reviewNo);	
	
	//게임 리뷰 수정
	public int updateGameReview(Review review);
	
	//회원번호로 리뷰 전체보기
	public List<Review> selectByUserNo(int uNo);
		
	//게임번호로 리뷰 전체보기
	public List<Review> selectByGameNo(int gNo);
}
