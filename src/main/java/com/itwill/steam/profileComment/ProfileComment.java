package com.itwill.steam.profileComment;

import java.util.Date;

import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
 이름            널?       유형             
------------- -------- -------------- 
PC_NO         NOT NULL NUMBER(10)     
PC_CREATED_AT          DATE           
PC_COMMENT             VARCHAR2(2000) 
U_NO                   NUMBER(10)     
U_FNO                  NUMBER(10)     
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProfileComment {
	private int pcNo; //프로필 번호
	private Date pcCreatedAt; //방명록 작성 시간
	private String pcComment; //방명록 내용
	
	private User user;//코멘트 작성자
	private int uFno;//프로필 주인
}