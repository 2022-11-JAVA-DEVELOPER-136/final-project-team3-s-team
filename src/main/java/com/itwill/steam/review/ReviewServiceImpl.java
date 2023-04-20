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
		int recommend = review.getReviewRecommend();

		if (recommend >= 1 && recommend <= 10) {
			review.setReviewRecommend(recommend);
			// 별점 관련 작성을 어떻게 해야될지 몰라서 일단 switch문으로 했는데 이건 따로 물어보기
			double star = 0.0;

			switch (recommend) {
			case 1:
				star = 0.5;
				break;
			case 2:
				star = 1.0;
				break;
			case 3:
				star = 1.5;
				break;
			case 4:
				star = 2.0;
				break;
			case 5:
				star = 2.5;
				break;
			case 6:
				star = 3.0;
				break;
			case 7:
				star = 3.5;
				break;
			case 8:
				star = 4.0;
				break;
			case 9:
				star = 4.5;
				break;
			case 10:
				star = 5.0;
				break;
			}
			review.setReviewRecommend(recommend);
		} else {
			// 잘못된 인자가 전달되면 예외 발생(null/값의 범위 벗어남/잘못된형식일때)
			throw new IllegalArgumentException("recommend value: " + recommend);
		}

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

	@Override
	public int updateReviewLike(int reviewNo) {
		return reviewDao.updateReviewLike(reviewNo);
	}

	@Override
	public int updateReviewDisLike(int reviewNo) {
		return reviewDao.updateReviewDisLike(reviewNo);
	}

	@Override
	public Review selectByReviewNo(int reviewNo) {
		return reviewDao.selectByReviewNo(reviewNo);
	}
}
