package com.itwill.steam.chatRoom;

import java.util.List;

import com.itwill.steam.chat.Chat;

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
public class ChatRoom {
/*
 * 이름      널?       유형            
------- -------- ------------- 
CR_NO   NOT NULL NUMBER(10)    
CR_NAME          VARCHAR2(100) 
 */
	private int crNo;
	private String crName;
	
	private List<Chat> chatList;
}
