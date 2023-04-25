package com.itwill.steam.profileComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.user.User;

@Service
public class ProfileCommentServiceImpl implements ProfileCommentService {
	@Autowired
	private ProfileCommentDao profileCommentDao;

	@Override
	public int insertProfileComment(ProfileComment profileComment) {
		return profileCommentDao.insertProfileComment(profileComment);
	}

	@Override
	public int updateProfileComment(ProfileComment profileComment) {
		return profileCommentDao.updateProfileComment(profileComment);
	}

	@Override
	public int deleteProfileComment(int pcNo) {
		return profileCommentDao.deleteProfileComment(pcNo);
	}

	@Override
	public List<ProfileComment> selectByProfileUserNo(User user) {
		return profileCommentDao.selectByProfileUserNo(user);
	}
}
