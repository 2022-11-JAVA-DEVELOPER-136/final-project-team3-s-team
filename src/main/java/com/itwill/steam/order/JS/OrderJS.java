package com.itwill.steam.order.JS;


import java.util.Date;
import java.util.List;

import com.itwill.steam.orderItem.OrderItem;
import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderJS {

	/*
	 * o_no 			NUMBER(10) 	NULL , 
	 * o_date 			DATE 		NULL , 
	 * o_total_price 	NUMBER(10)  NULL ,
	 * u_no 			NUMBER(10)  NULL
	 */
	
	private int o_no;
	private Date o_date;
	private int o_total_price;
	
	private User user;
	private List<User> userList;
	private List<User> orderLisdt;
	private List<OrderItem> orderItemList;
	
	
}
