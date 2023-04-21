package com.itwill.steam.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class OrderDaoImplTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	private OrderDao orderDao;
	
	//@Test
	void testInsertOrder() {
		Order order = Order.builder().oTotalPrice(120000).uNo(3).build();
		orderDao.insertOrder(order);
	}

	@Test
	void testFindByUserNo() {
		System.out.println(orderDao.findByUserNo(1));
		
	}

	@Test
	void testFindByOrderNo() {
		System.out.println(orderDao.findByOrderNo(1));
	}

	//@Test
	void testDeleteByUserNo() {
		System.out.println(orderDao.deleteByUserNo(2));
	}

	@Test
	void testDeleteByOrderNo() {
		System.out.println(orderDao.deleteByOrderNo(2));
	}

//	@Test
//	void testFindByUserGame() {
//		System.out.println(orderDao.findByUserGame(1));
//	}

}
