package com.itwill.steam.order.JS;

import java.util.List;

public interface OrderService {
	
	int insertOrder(Order orders) throws Exception;
	
	int deleteOrder(int o_no) throws Exception;
	
	Order selectByNo(int o_no) throws Exception;
	
	List<Order> selectAllById(String u_id) throws Exception;
	
	Order selectByG_No(int g_no) throws Exception;
	
}
