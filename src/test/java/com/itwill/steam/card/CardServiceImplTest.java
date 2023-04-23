package com.itwill.steam.card;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.user.User;

class CardServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	
	@Autowired
	private CardService cardService;
//	@Test
	void testCreateCard() {
		Card card = new Card(0, "블랙카드", "0000-0000-0000-0000", "20년", 163,User.builder().uNo(1).build());
		cardService.createCard(card);
	}

//	@Test
	void testRemoveCard() {
		cardService.removeCard(10);
	}

//	@Test
	void testUpdateCardName() {
		Card card = new Card(0, "블랙카드", "0000-0000-0000-0000", "20년", 163,User.builder().uNo(1).build());
		cardService.updateCard(card);
	}

//	@Test
	void testFindCardByNo() {
		Card card = cardService.findCardByNo(1);
		System.out.println("특정회원 : "+card);
	}

}
