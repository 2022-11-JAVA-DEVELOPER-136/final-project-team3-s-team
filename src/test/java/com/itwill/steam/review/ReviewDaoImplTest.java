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
import com.itwill.steam.review.mapper.ReviewMapper;


class ReviewDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Test
	void InsertGameReview(){
		Review review = new Review(115,null,null,"테스트용이지용",0,1,3);
		reviewDao.insertGameReview(review);
	}
	
	//@Test
	void deleteGameReview(){
		reviewDao.deleteGameReview(111);		
	}
	
	@Test
	void updateGameReview(){
		int rowCount = reviewDao.updateGameReview(new Review(11,null,null,"수정테스트!!바뀌어라~",1,0,1));
	}
	//@Test
	void selectByUserNo() {
		List<Review> reviewByUserNoList = reviewDao.selectByUserNo(1);
		System.out.println(reviewByUserNoList);
	}
	
	@Test
	void selectByGameNo() {
		List<Review> reviewByGameNoList = reviewDao.selectByGameNo(6);
		System.out.println(reviewByGameNoList);
	}
	
}
