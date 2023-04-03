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
	public int insertOrder(OrderYS orderYS) {
		return orderMapper.insertOrder(orderYS);
	}

	@Override
	public List<OrderYS> findByUserNo(int uNo) {
		return orderMapper.findByUserNo(uNo);
	}

	@Override
	public List<OrderYS> findByOrderNo(int oNo) {
		return orderMapper.findByOrderNo(oNo);
	}

	@Override
	public int deleteByUserNo(int uNo) {
		return orderMapper.deleteByUserNo(uNo);
	}

	@Override
	public int deleteByOrderNo(int oNO) {
		return orderMapper.deleteByOrderNo(oNO);
	}

	@Override
	public List<OrderYS> findByUserGame(int uNo) {
		return orderMapper.findByUserGame(uNo);
	}

}
