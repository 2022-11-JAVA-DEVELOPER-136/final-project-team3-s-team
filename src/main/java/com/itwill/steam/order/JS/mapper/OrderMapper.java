package com.itwill.steam.order.JS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.order.Order;

@Mapper
public interface OrderMapper {

	public List<Order> findByOrderNo(int o_no);
	
	public List<Order> findByUserNo(int u_no);
	
	public int deleteByUserNo(int u_no);
	
	public int deleteByOrderNo(int o_no);
	
	public List<Order> findByUserGame(int u_no);
	
	public List<Order> findByOrderItem(int u_no);
	
	
}
