package com.itwill.steam.order.YS;

import java.util.List;

import com.itwill.steam.order.Order;
import com.itwill.steam.orderItem.OrderItem;

public interface OrderDaoYS {
	//주문생성하기
	public int insertOrder(OrderYS orderYS);
	//유저번호로 검색하기
	public List<OrderYS> findByUserNo(int uNo);
	//주문번호로 검색하기
	public List<OrderYS> findByOrderNo(int oNo);
	//유저번호로 품목삭제
	public int deleteByUserNo(int uNo);
	//주문번호로 품목삭제
	public int deleteByOrderNo(int oNO);
	//유저가 주문한 목록 검색
	public List<OrderYS> findByUserGame(int uNo);
	


}
