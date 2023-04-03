package com.itwill.steam.review;

import java.util.Date;
import java.util.List;

import com.itwill.steam.game.Game;
import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
이름                널?       유형             
----------------- -------- -------------- 
REVIEW_NO         NOT NULL NUMBER(10)     
REVIEW_CREATED_AT          DATE           
REVIEW_UPDATED_AT          DATE           
REVIEW_COMMENT             VARCHAR2(2000) 
REVIEW_RECOMMEND           NUMBER(10)     
U_NO                       NUMBER(10)     
G_NO                       NUMBER(10)      
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Review {
	private int reviewNo;
	private Date reviewCreatedAt;
	private Date reviewUpdatedAt;
	private String reviewComment;
	private int reviewRecommend;
			
	private int uNo;
	private int gNo;
}
