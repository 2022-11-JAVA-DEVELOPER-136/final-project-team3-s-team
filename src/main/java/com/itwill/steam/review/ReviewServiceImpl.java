package com.itwill.steam.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public int insertGameReview(Review review) {
		return reviewDao.insertGameReview(review);
	}

	@Override
	public int deleteGameReview(int reviewNo) {
		return reviewDao.deleteGameReview(reviewNo);
	}

	@Override
	public int updateGameReview(Review review) {
		return reviewDao.updateGameReview(review);
	}

	@Override
	public List<Review> selectByUserNo(User user) {
		return reviewDao.selectByUserNo(user);
	}

	@Override
	public List<Review> selectByGameNo(Game game) {
		return reviewDao.selectByGameNo(game);
	}

	@Override
	public List<Review> selectByDateDesc(Game game) {
		return reviewDao.selectByDateDesc(game);
	}

	@Override
	public List<Review> selectByLikeDesc(Game game) {
		return reviewDao.selectByLikeDesc(game);
	}
}
