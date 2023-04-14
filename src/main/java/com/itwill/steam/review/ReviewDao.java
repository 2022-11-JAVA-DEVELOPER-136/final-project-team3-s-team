package com.itwill.steam.review;

import java.util.List;

import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

public interface ReviewDao {
	
	//게임 리뷰 작성
	public int insertGameReview(Review review);
		
	//게임 리뷰 삭제
	public int deleteGameReview(int reviewNo);	
	
	//게임 리뷰 수정
	public int updateGameReview(Review review);
	
	//회원번호로 리뷰 전체보기
	public List<Review> selectByUserNo(User user);
		
	//게임번호로 리뷰 전체보기
	public List<Review> selectByGameNo(Game game);
	
	//리뷰 최신등록순 정렬보기
	public List<Review> selectByDateDesc();

	//리뷰 추천수 내림차순 정렬보기
	public List<Review> selectByLikeDesc();
}
