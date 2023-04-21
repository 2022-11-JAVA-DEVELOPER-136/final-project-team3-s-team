package com.itwill.steam.order;

import java.util.Date;
import java.util.List;

import com.itwill.steam.orderItem.OrderItem;

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
public class Order {

	/*
	 * o_no 			NUMBER(10) 	NULL , 
	 * o_date 			DATE 		NULL , 
	 * o_total_price 	NUMBER(10)  NULL ,
	 * u_no 			NUMBER(10)  NULL
	 */
	
	private int oNo;
	private Date oDate;
	private int oTotalPrice;
	
	private int uNo;
	//private List<User> userList;
	//private List<User> orderList;
	private List<OrderItem> orderItemList;
	
}
