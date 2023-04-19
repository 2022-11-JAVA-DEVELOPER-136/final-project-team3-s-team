package com.itwill.steam.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.game.Game;
import com.itwill.steam.review.Review;
import com.itwill.steam.user.User;

@Mapper
public interface ReviewMapper {
	
	// 게임 리뷰 작성
	public int insertGameReview(Review review);

	// 게임 리뷰 삭제
	public int deleteGameReview(int reviewNo);

	// 게임 리뷰 수정
	public int updateGameReview(Review review);

	// 회원번호로 리뷰 전체보기
	public List<Review> selectByUserNo(User user);

	// 게임번호로 리뷰 전체보기
	public List<Review> selectByGameNo(Game game);

	// 리뷰 최신등록순 정렬보기
	public List<Review> selectByDateDesc(Game game);

	// 리뷰 추천수 내림차순 정렬보기
	public List<Review> selectByLikeDesc(Game game);

	// 리뷰글 좋아요
	public int updateReviewLike(int reviewNo);

	// 리뷰글 싫어요
	public int updateReviewDisLike(int reviewNo);

	public Review selectByReviewNo(int reviewNo);
	
	
}
