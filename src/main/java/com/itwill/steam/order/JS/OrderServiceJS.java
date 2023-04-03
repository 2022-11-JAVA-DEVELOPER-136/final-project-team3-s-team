package com.itwill.steam.order.JS;

import java.util.List;

public interface OrderServiceJS {
	
	int insertOrder(OrderJS orders) throws Exception;
	
	int deleteOrder(int o_no) throws Exception;
	
	OrderJS selectByNo(int o_no) throws Exception;
	
	List<OrderJS> selectAllById(String u_id) throws Exception;
	
	OrderJS selectByG_No(int g_no) throws Exception;
	
}
