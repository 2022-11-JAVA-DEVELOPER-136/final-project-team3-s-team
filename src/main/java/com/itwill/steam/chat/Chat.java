package com.itwill.steam.chat;

import java.util.Date;

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
public class Chat {
/*
 * 이름              널?       유형             
--------------- -------- -------------- 
CHAT_NO         NOT NULL NUMBER(10)     
CHAT_CONTENT             VARCHAR2(4000) 
CHAT_CREATED_AT          DATE           
U_NO                     NUMBER(10)     
CR_NO                    NUMBER(10)     

 */
	private int chatNo;
	private String chatContent;
	private Date chatCreatedAt;
	private int uNo;
	private int crNo;
}
