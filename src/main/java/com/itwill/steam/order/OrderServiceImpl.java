package com.itwill.steam.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}
	@Override
	public List<Order> findByUserNo(int uNo) {
		return orderDao.findByUserNo(uNo);
	}
	@Override
	public List<Order> findByOrderNo(int oNo){
		return orderDao.findByOrderNo(oNo);
	}
	@Override
	public int deleteByUserNo(int uNo) {
		return orderDao.deleteByUserNo(uNo);
	}
	@Override
	public int deleteByOrderNo(int oNO) {
		return orderDao.deleteByOrderNo(oNO);
	}
	@Override
	public List<Order> findByUserGame(int uNo) {
		return orderDao.findByUserGame(uNo);
	}
}
