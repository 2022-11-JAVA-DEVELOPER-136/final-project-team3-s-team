package com.itwill.steam.card;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
		cardDao.updateCardName("구구",5);
	}
	//@Test
	void testFindCardByNo() {
		List<Card> cardList= cardDao.findCardByNo(1);
		System.out.println(cardList);
	}
}
