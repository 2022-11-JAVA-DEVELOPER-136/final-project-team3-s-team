package com.itwill.steam.card.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.steam.card.Card;
import com.itwill.steam.user.User;

public interface CardMapper {
	
	// 카드등록
	public int createCard(Card card);
	
	// 카드삭제
	public int removeCard(int cardSeq);
	
	// 카드 이름변경
	public int updateCardName(Map<String, Object> map);
	
	// 특정회원 카드 정보 불러오기
	public List<Card> findCardByNo(int uNo);
}
