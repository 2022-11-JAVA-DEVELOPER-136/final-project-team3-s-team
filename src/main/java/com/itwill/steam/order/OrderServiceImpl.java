package com.itwill.steam.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.orderItem.OrderItem;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
//	@Override
//	public int insertOrderItem(OrderItem orderItem) {
//		
//		return 0;
//	}
	
	@Override
	public int insertOrder(Order order) {
		
		//트랜잭션 시작 - 해야 함
		int result = orderDao.insertOrder(order);
		for(OrderItem orderItem:order.getOrderItemList()) {
			orderDao.insertOrderItem(orderItem);
		}
		//트랜잭션 종료 - 해야 함
		
		return result;
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
	public int deleteByOrderNo(int oNo) {
		return orderDao.deleteByOrderNo(oNo);
	}
	//@Override
	//public List<Order> findByUserGame(int uNo) {
		//return orderDao.findByUserGame(uNo);
	//}
}
