package com.itwill.steam.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
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
	public int updateCardName(String cardName,int cardSeq) {
		Map<String, Object> map = new HashMap();
		map.put("cardName", cardName);
		map.put("cardSeq", cardSeq);
		return cardMapper.updateCardName(map);
	}

	@Override
	public List<Card> findCardByNo(int uNo) {
		
		return cardMapper.findCardByNo(uNo);
	}

}
