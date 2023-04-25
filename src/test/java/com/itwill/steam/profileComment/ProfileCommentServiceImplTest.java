package com.itwill.steam.profileComment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.user.User;

class ProfileCommentServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	private ProfileCommentService profileCommentService;

	//@Test
	void testInsertProfileComment() {
		User user = User.builder().uNo(2).build();
		User profileUser = User.builder().uNo(1).build();
		
		ProfileComment profileComment = new ProfileComment(0, null, "방명록 service테스트용", user, profileUser.getUNo());
		profileCommentService.insertProfileComment(profileComment);
	}

	//@Test
	void testUpdateProfileComment() {
		User user = User.builder().uNo(2).build();
		User profileUser = User.builder().uNo(1).build();
		
		ProfileComment profileComment = new ProfileComment(5, null, "방명록 service테스트용 수정", user, profileUser.getUNo());
		profileCommentService.updateProfileComment(profileComment);
	}

	//@Test
	void testDeleteProfileComment() {
		profileCommentService.deleteProfileComment(5);
	}

	@Test
	void testSelectByProfileUserNo() {
		User profileUser = User.builder().uNo(3).build();
		
		List<ProfileComment> profileCommentList = profileCommentService.selectByProfileUserNo(profileUser);
	}

}
