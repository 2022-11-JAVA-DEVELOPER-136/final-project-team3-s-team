package com.itwill.steam.profileComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.profileComment.mapper.ProfileCommentMapper;
import com.itwill.steam.user.User;

@Repository
public class ProfileCommentDaoImpl implements ProfileCommentDao {
	@Autowired
	private ProfileCommentMapper profileCommentMapper;

	@Override
	public int insertProfileComment(ProfileComment profileComment) {
		return profileCommentMapper.insertProfileComment(profileComment);
	}

	@Override
	public int updateProfileComment(ProfileComment profileComment) {
		return profileCommentMapper.updateProfileComment(profileComment);
	}

	@Override
	public int deleteProfileComment(int pcNo) {
		return profileCommentMapper.deleteProfileComment(pcNo);
	}

	@Override
	public List<ProfileComment> selectByProfileUserNo(User user) {
		return profileCommentMapper.selectByProfileUserNo(user);
	}

}
