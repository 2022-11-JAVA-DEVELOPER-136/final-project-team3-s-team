package com.itwill.steam.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.game.Game;
import com.itwill.steam.review.mapper.ReviewMapper;
import com.itwill.steam.user.User;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	@Autowired
	private ReviewMapper reviewMapper;

	// 게임 리뷰 작성
	@Override
	public int insertGameReview(Review review) {
		return reviewMapper.insertGameReview(review);
	}

	// 리뷰 삭제
	@Override
	public int deleteGameReview(int reviewNo) {
		return reviewMapper.deleteGameReview(reviewNo);
	}

	// 리뷰 수정
	@Override
	public int updateGameReview(Review review) {
		return reviewMapper.updateGameReview(review);
	}

	@Override
	public List<Review> selectByUserNo(User user) {
		return reviewMapper.selectByUserNo(user);
	}

	@Override
	public List<Review> selectByGameNo(Game game) {
		return reviewMapper.selectByGameNo(game);
	}

	@Override
	public List<Review> selectByDateDesc(Game game) {
		return reviewMapper.selectByDateDesc(game);
	}

	@Override
	public List<Review> selectByLikeDesc(Game game) {
		return reviewMapper.selectByLikeDesc(game);
	}

	@Override
	public int updateReviewLike(int reviewNo) {
		return reviewMapper.updateReviewLike(reviewNo);
	}

	@Override
	public int updateReviewDisLike(int reviewNo) {
		return reviewMapper.updateReviewDisLike(reviewNo);
	}

	@Override
	public Review selectByReviewNo(int reviewNo) {
		return reviewMapper.selectByReviewNo(reviewNo);
	}

	
}	
