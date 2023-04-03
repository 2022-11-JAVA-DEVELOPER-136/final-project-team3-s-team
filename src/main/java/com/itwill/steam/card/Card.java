package com.itwill.steam.card;

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
public class Card {
/*
 * 이름           널?       유형            
------------ -------- ------------- 
CARD_SEQ     NOT NULL NUMBER(10)    
CARD_NAME             VARCHAR2(100) 
CARD_NUMBER           VARCHAR2(20)  
CARD_EX_DATE          VARCHAR2(10)  
CARD_CVC              NUMBER(10)    
U_NO                  NUMBER(10)    

 */
	private int cardSeq;
	private String cardName;
	private String cardNumber;
	private String cardExDate;
	private int cardCvc;
	private User user;
	
	
	
	
	
}
