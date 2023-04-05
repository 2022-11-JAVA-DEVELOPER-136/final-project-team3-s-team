package com.itwill.steam.review;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class ReviewServiceImplTest extends FinalProjectTeam3STeamApplicationTests{

	@Autowired
	private ReviewService reviewService;
	
	//@Test
	void testInsertGameReview() {
		Review review = new Review(119,null,null,"테스트용이지용",0,1,3);
		reviewService.insertGameReview(review);
	}

	//@Test
	void testDeleteGameReview() {
		reviewService.deleteGameReview(1);
	}

	//@Test
	void testUpdateGameReview() {
		int rowCount = reviewService.updateGameReview(new Review(11,null,null,"서비스테스트!!바뀌어라~",1,0,1));
	}

	//@Test
	void testSelectByUserNo() {
		List<Review> reviewByUserNoList = reviewService.selectByUserNo(1);
		System.out.println(reviewByUserNoList);
	}

	//@Test
	void testSelectByGameNo() {
		List<Review> reviewByGameNoList = reviewService.selectByGameNo(6);
		System.out.println(reviewByGameNoList);
	}

}
