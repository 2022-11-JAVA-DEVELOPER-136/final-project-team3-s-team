package com.itwill.steam.review;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.steam.FinalProjectTeam3STeamApplication;
import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.game.Game;
import com.itwill.steam.review.mapper.ReviewMapper;
import com.itwill.steam.user.User;


class ReviewDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Test
	void InsertGameReview(){
		User user = User.builder().uNo(1).build();
		Game game = Game.builder().gNo(1).build();		
		Review review = new Review(100,null,null,"테스트용리뷰1",1,1,1,user,game);
		reviewDao.insertGameReview(review);
	}
	
	//@Test
	void deleteGameReview(){
		reviewDao.deleteGameReview(111);		
	}
	
	//@Test
	void updateGameReview(){
		User user = User.builder().uNo(3).build();
		Game game = Game.builder().gNo(3).build();
		//int rowCount = reviewDao.updateGameReview(new Review(12,null,null,"리뷰 수정 테스트!!",1,0,1,user,game));
	}
	
	//@Test
	void selectByUserNo() {
		User user = User.builder().uNo(2).build();
		List<Review> reviewByUserNoList = reviewDao.selectByUserNo(user);
		System.out.println(reviewByUserNoList);
	}
	
	//@Test
	void selectByGameNo() {
		Game game = Game.builder().gNo(6).build();
		List<Review> reviewByGameNoList = reviewDao.selectByGameNo(game);
		System.out.println(reviewByGameNoList);
	}
	
	//@Test
	void selectByDateDesc() {
		User user = new User();
		Game game = Game.builder().gNo(5).build();
		List<Review> reviewByDateDescList = reviewDao.selectByDateDesc(game);
		System.out.println(reviewByDateDescList);
		System.out.println(user);
	}
	
	//@Test
	void selectByLikeDesc() {
		Game game = Game.builder().gNo(4).build();
		List<Review> reviewByLikeDescList = reviewDao.selectByLikeDesc(game);
		System.out.println(reviewByLikeDescList);
	}
	
}
