package com.itwill.steam.card;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;
import com.itwill.steam.user.User;



class CardDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	CardDao cardDao;

//	@Test
	void TestCreateCard() {
		User user = new User();
		user.setUNo(1);
		Card card = new Card(0, "라리", "1111", "1111",163,user);
		int result =cardDao.createCard(card);
		System.out.println(result);
	}
	//@Test
	void testRemoveCard() {
		int result =cardDao.removeCard(6);
		System.out.println(result);
	}
	//@Test
	void testupdateCardName() {
		User user = new User();
		user.setUNo(1);
		Card card = new Card(0, "라리", "1111", "1111",163, user);
		cardDao.updateCard(card);
	}
	//@Test
	void testFindCardByNo() {
		Card card = cardDao.findCardByNo(1);
		System.out.println(card);
	}
}
