package com.itwill.steam.review;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

@Transactional
class ReviewServiceImplTest extends FinalProjectTeam3STeamApplicationTests{

	@Autowired
	private ReviewService reviewService;
	
	//@Test
	void testInsertGameReview() {
		User user = User.builder().uNo(1).build();
		Game game = Game.builder().gNo(1).build();
		//Review review = new Review(119,null,null,"테스트용이지용",0,1,3,user,game);
		//reviewService.insertGameReview(review);
	}
	
	//@Test
	void testDeleteGameReview() {
		reviewService.deleteGameReview(1);
	}
	
	//@Test
	void testUpdateGameReview() {
		User user = User.builder().uNo(1).build();
		Game game = Game.builder().gNo(1).build();
		//int rowCount = reviewService.updateGameReview(new Review(11,null,null,"서비스테스트!!바뀌어라~",1,0,1,user,game));
	}
	
	
	//@Test
	void testSelectByUserNo() {
		User user = User.builder().uNo(2).build();
		List<Review> reviewByUserNoList = reviewService.selectByUserNo(user);
		System.out.println(reviewByUserNoList);
	}

	//@Test
	void testSelectByGameNo() {
		Game game = Game.builder().gNo(1).build();
		List<Review> reviewByGameNoList = reviewService.selectByGameNo(game);
		System.out.println(reviewByGameNoList);
	}
	
	//@Test
	void testSelectByDateDesc() {
		Game game = Game.builder().gNo(2).build();
		List<Review> reviewByDateDesc = reviewService.selectByDateDesc(game);
	}
	
	@Test
	void testSelectByLikeDesc() {
		Game game = Game.builder().gNo(1).build();
		List<Review> reviewByLikeDesc = reviewService.selectByLikeDesc(game);
	}

}
