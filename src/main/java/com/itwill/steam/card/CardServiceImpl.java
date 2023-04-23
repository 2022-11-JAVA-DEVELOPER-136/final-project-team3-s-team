package com.itwill.steam.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.exception.ExistedUserException;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardDao cardDao;
	
	// 카드등록
	@Override
	public int createCard(Card card) {
		// 카드등록 체크(유저 한명당 카드만 하나등록)
		if(!cardExistChk(card)) {
			System.out.println("이미카드등록!!!");
			throw new ExistedUserException("이미 카드가 등록되어있습니다.");
		}
		
		return cardDao.createCard(card);
	}
	
	private boolean cardExistChk(Card card) {
		boolean chk = false;
		card = findCardByNo(card.getUser().getUNo());
		
		if(card == null) {
			chk = true;
		}
		
		return chk;
	}

	// 카드삭제
	@Override
	public int removeCard(int cardSeq) {
		return cardDao.removeCard(cardSeq);
	}

	// 카드 변경
	@Override
	public int updateCard(Card card) {
		return cardDao.updateCard(card);
	}

	// 특정회원 카드 정보 불러오기
	@Override
	public Card findCardByNo(int uNo) {
		return cardDao.findCardByNo(uNo);
	}

}
