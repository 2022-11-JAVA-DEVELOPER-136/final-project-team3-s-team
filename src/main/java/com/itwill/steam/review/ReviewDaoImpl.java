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

	//게임 리뷰 작성
	@Override
	public int insertGameReview(Review review){		
		return reviewMapper.insertGameReview(review);
	}
	
	//리뷰 삭제
	@Override
	public int deleteGameReview(int reviewNo){
		return reviewMapper.deleteGameReview(reviewNo);
	}

	//리뷰 수정
	@Override
	public int updateGameReview(Review review){		
		return reviewMapper.updateGameReview(review);
	}

	@Override
	public List<Review> selectByUserNo(User user) {
		return reviewMapper.selectByUser(user);
	}

	@Override
	public List<Review> selectByGameNo(Game game) {
		return reviewMapper.selectByGame(game);
	}

	@Override
	public List<Review> selectByDateDesc() {
		return reviewMapper.selectByDateDesc();
	}

	@Override
	public List<Review> selectByLikeDesc() {
		return reviewMapper.selectByLikeDesc();
	}

	
}	
