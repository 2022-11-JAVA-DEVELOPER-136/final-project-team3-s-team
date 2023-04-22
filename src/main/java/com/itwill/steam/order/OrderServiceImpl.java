package com.itwill.steam.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.game.GameDao;
import com.itwill.steam.orderItem.OrderItem;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderDao orderDao;
	private final GameDao gameDao;
//	@Override
//	public int insertOrderItem(OrderItem orderItem) {
//		
//		return 0;
//	}
	
	@Override
	public int insertOrder(Order order) {
		
		/*****트랜잭션 시작*****/
		int result = orderDao.insertOrder(order);//주문 입력
		for(OrderItem orderItem:order.getOrderItemList()) {
			orderDao.insertOrderItem(orderItem);//주문아이템 입력
			gameDao.increaseSellCountByNo(orderItem.getGame().getGNo());//게임 판매량 1 증가
		}
		/*****트랜잭션 종료*****/
		
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
