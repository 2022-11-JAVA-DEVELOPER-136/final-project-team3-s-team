package com.itwill.steam.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class OrderServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	OrderService orderService;
	//@Test
	void testInsertOrder() {
		Order order = Order.builder().oTotalPrice(120000).uNo(3).build();
		orderService.insertOrder(order);
	}

	//@Test
	void testFindByUserNo() {
		orderService.findByUserNo(1);
	}

	//@Test
	void testFindByOrderNo() {
		orderService.findByOrderNo(2);
	}

	@Test
	void testDeleteByUserNo() {
		orderService.deleteByUserNo(1);
	}

	@Test
	void testDeleteByOrderNo() {
		orderService.deleteByOrderNo(1);
	}

	//@Test
//	void testFindByUserGame() {
//		orderService.findByUserGame(1);
//	}

}
