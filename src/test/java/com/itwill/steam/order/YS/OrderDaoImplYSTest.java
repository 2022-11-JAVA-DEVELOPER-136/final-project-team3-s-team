package com.itwill.steam.order.YS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class OrderDaoImplYSTest extends FinalProjectTeam3STeamApplicationTests {
	
	@Autowired
	private OrderDaoYS orderDaoYS;
	
	@Test
	void testInsertOrder() {
		OrderYS orderYS = new OrderYS(1,new Date(),20000,1);
		orderDaoYS.insertOrder(orderYS);
	}

	//@Test
	void testFindByUserNo() {
		fail("Not yet implemented");
	}

	//@Test
	void testFindByOrderNo() {
		fail("Not yet implemented");
	}

	//@Test
	void testDeleteByUserNo() {
		fail("Not yet implemented");
	}

	//@Test
	void testDeleteByOrderNo() {
		fail("Not yet implemented");
	}

	//@Test
	void testFindByUserGame() {
		fail("Not yet implemented");
	}

}
