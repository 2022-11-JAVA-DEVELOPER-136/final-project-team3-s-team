package com.itwill.steam.order.JS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.order.mapper.OrderMapper;

public class OrderDaoImplJS implements OrderDaoJS {
	
	@Autowired
	private OrderMapper orderMaaper;

	@Override
	public int insertOrder(int o_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderJS> findByUserNo(int u_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByUserNo(int u_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByOrderNo(int o_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderJS> findByUserGame(int u_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderJS> findByOrderItem(int u_no) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
}
