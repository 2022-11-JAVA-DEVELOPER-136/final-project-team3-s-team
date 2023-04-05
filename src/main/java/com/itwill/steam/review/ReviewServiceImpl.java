package com.itwill.steam.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Review> selectByUserNo(int uNo) {
		return reviewDao.selectByUserNo(uNo);
	}

	@Override
	public List<Review> selectByGameNo(int gNo) {
		return reviewDao.selectByGameNo(gNo);
	}
}
