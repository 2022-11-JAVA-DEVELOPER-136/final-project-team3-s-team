package com.itwill.steam.profileComment;

import java.util.Date;

import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProfileComment {
	private int pcNo;
	private Date pcCreatedAt;
	private String pcComment;
	
	private User user;//코멘트 작성자
	private User profileUser;//프로필 주인
}