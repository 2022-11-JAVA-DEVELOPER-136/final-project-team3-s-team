package com.itwill.steam.order.YS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.order.mapper.OrderMapper;

@Repository(value = "OrderDaoYS")
public class OrderDaoImplYS implements OrderDaoYS {
	@Autowired
	OrderMapper orderMapper;
	
	
	
}
