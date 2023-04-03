package com.itwill.steam.order.YS;


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
public class OrderYS {

	/*
	 * o_no 			NUMBER(10) 	NULL , 
	 * o_date 			DATE 		NULL , 
	 * o_total_price 	NUMBER(10)  NULL ,
	 * u_no 			NUMBER(10)  NULL
	 */
	
	private int oNO;
	private Date oDate;
	private int oTotalPrice;
	
	private int uNo;
	//private List<User> userList;
	//private List<User> orderList;
	//private List<OrderItem> orderItemList;
	
	
}
