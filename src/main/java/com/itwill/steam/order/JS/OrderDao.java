package com.itwill.steam.order.JS;

import java.util.List;

public interface OrderDao {
	
	// 주문번호 검색
	public int insertOrder(int o_no);
	
	// 유저번호 검색
	public List<Order> findByUserNo(int u_no);
	
	// 유저번호로 주문 상품 삭제
	public int deleteByUserNo(int u_no);
	
	// 주문번호로 주문 상품 삭제
	public int deleteByOrderNo(int o_no);
	
	// 주문 목록 검색
	public List<Order> findByUserGame(int u_no);
	
	// 주문 상세 목록
	public List<Order> findByOrderItem(int u_no);
	
}
