package com.itwill.steam.order.YS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.itwill.steam.order.Order;


import com.itwill.steam.order.mapper.OrderMapper;

@Repository(value = "OrderDaoYS")
public class OrderDaoImplYS implements OrderDaoYS {
	@Autowired
	OrderMapper orderMapper;
	
	
	
	@Override
	public int insertOrder(Order order) {
		return 0;
	}

	@Override
	public List<Order> findByUserNo(int uNo) {
		return null;
	}

	@Override
	public List<Order> findByOrderNo(int oNo) {
		return null;
	}

	@Override
	public int deleteByUserNo(int uNo) {
		return 0;
	}

	@Override
	public int deleteByOrderNo(int oNO) {
		return 0;
	}

	@Override
	public List<Order> findByUserGame(int uNo) {
		return null;
	}

}
