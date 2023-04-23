package com.itwill.steam.card;

public interface CardDao {

	// 카드등록
	public int createCard(Card card);
	
	// 카드삭제
	public int removeCard(int cardSeq);
	
	// 카드 변경
	public int updateCard(Card card);
	
	// 특정회원 카드 정보 불러오기
	public Card findCardByNo(int uNo);
		
}
