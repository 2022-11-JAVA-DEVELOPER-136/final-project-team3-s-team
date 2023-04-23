package com.itwill.steam.card.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.card.Card;

@Mapper
public interface CardMapper {
	
	// 카드등록
	public int createCard(Card card);
	
	// 카드삭제
	public int removeCard(int cardSeq);
	
	// 카드 이름변경
	public int updateCard(Card card);
	
	// 특정회원 카드 정보 불러오기
	public Card findCardByNo(int uNo);
}
