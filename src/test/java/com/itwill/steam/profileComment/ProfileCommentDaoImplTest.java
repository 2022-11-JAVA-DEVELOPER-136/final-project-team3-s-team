package com.itwill.steam.profileComment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.user.User;

class ProfileCommentDaoImplTest extends FinalProjectTeam3STeamApplicationTests{

	@Autowired
	private ProfileCommentDao profileCommentDao;
	
	//@Test
	void testInsertProfileComment() {
		User user = User.builder().uNo(1).build();
		User profileUser = User.builder().uNo(2).build();
		
		ProfileComment profileComment = new ProfileComment(0, null, "방명록 dao테스트용", user, profileUser.getUNo());
		profileCommentDao.insertProfileComment(profileComment);
	}

	//@Test
	void testUpdateProfileComment() {
		User user = User.builder().uNo(1).build();
		User profileUser = User.builder().uNo(3).build();
		
		ProfileComment profileComment = new ProfileComment(1, null, "방명록 dao테스트용 업데이트!!!", user, profileUser.getUNo());
		profileCommentDao.updateProfileComment(profileComment);
	}

	//@Test
	void testDeleteProfileComment() {
		profileCommentDao.deleteProfileComment(4);
	}

	@Test
	void testSelectByProfileUserNo() {
		User profileUser = User.builder().uNo(3).build();
		
		List<ProfileComment> profileCommentList = profileCommentDao.selectByProfileUserNo(profileUser);
		System.out.println(">>>>>"+profileCommentList);
		System.out.println(">>>>>"+profileCommentList.size());
	}
}