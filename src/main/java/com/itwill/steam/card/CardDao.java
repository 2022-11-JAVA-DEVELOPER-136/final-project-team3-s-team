package com.itwill.steam.card;

import java.util.List;

public interface CardDao {

	// 카드등록
	public int createCard(Card card);
	
	// 카드삭제
	public int removeCard(int cardSeq);
	
	// 카드 이름변경
	public int updateCardName(String cardName,int cardSeq);
	
	// 특정회원 카드 정보 불러오기
	public Card findCardByNo(int uNo);
		
}
