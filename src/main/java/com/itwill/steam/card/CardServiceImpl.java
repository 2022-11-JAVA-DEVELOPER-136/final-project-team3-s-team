package com.itwill.steam.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardDao cardDao;
	
	// 카드등록
	@Override
	public int createCard(Card card) {
		return cardDao.createCard(card);
	}

	// 카드삭제
	@Override
	public int removeCard(int cardSeq) {
		return cardDao.removeCard(cardSeq);
	}

	// 카드 이름변경
	@Override
	public int updateCardName(String cardName, int cardSeq) {
		return cardDao.updateCardName(cardName, cardSeq);
	}

	// 특정회원 카드 정보 불러오기
	@Override
	public List<Card> findCardByNo(int uNo) {
		return cardDao.findCardByNo(uNo);
	}

}
