package com.itwill.steam.user;

import java.util.List;

import com.itwill.steam.card.Card;
import com.itwill.steam.chat.Chat;
import com.itwill.steam.friend.Friend;

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
public class User {
/*
 * 이름         널?       유형             
---------- -------- -------------- 
U_NO       NOT NULL NUMBER(10)     
U_ID                VARCHAR2(50)   
U_PASSWORD          VARCHAR2(100)  
U_NAME              VARCHAR2(100)  
U_EMAIL             VARCHAR2(100)  
U_PHONE             VARCHAR2(50)   
U_NICKNAME          VARCHAR2(100)  
U_ADDR              VARCHAR2(1000) 

 */
	private int uNo;
	private String uId;
	private String uPassword;
	private String uName;
	private String uEmail;
	private String uPhone;
	private String uNickname;
	private String uAddr;
	
	//private List<Card> cardList;
	//private List<Chat> chatList;
	//private List<Friend> friendList;
	
	
	
	
	
	
	
	
	
	
}
