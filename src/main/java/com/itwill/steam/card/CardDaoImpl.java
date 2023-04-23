package com.itwill.steam.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.card.mapper.CardMapper;
@Repository
public class CardDaoImpl implements CardDao {
	@Autowired
	private CardMapper cardMapper;
	@Override
	public int createCard(Card card) {
		
		return cardMapper.createCard(card);
	}

	@Override
	public int removeCard(int cardSeq) {
		
		return cardMapper.removeCard(cardSeq);
	}

	@Override
	public int updateCard(Card card) {
		
		return cardMapper.updateCard(card);
	}

	@Override
	public Card findCardByNo(int uNo) {
		
		return cardMapper.findCardByNo(uNo);
	}

}
