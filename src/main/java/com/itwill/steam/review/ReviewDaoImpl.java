package com.itwill.steam.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.review.mapper.ReviewMapper;

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
	public List<Review> selectByUserNo(int uNo) {
		return reviewMapper.selectByUserNo(uNo);
	}

	@Override
	public List<Review> selectByGameNo(int gNo) {
		return reviewMapper.selectByGameNo(gNo);
	}

	
}	
