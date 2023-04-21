package com.itwill.steam.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.order.mapper.OrderMapper;
import com.itwill.steam.orderItem.OrderItem;
@Repository(value = "OrderDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public int insertOrderItem(OrderItem orderItem) {
		return orderMapper.insertOrderItem(orderItem);
	}
	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertOrder(order);
	}

	@Override
	public List<Order> findByUserNo(int uNo) {
		return orderMapper.findByUserNo(uNo);
	}

	@Override
	public List<Order> findByOrderNo(int oNo) {
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

//	@Override
//	public List<Order>findByUserGame(int uNo) {
//		return orderMapper.findByUserGame(uNo);
//	}

}