package com.itwill.steam.order.YS;

import java.util.Date;
import java.util.List;

import com.itwill.steam.order.Order;
import com.itwill.steam.orderItem.OrderItem;
import com.itwill.steam.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class orderYS {
	
	private int oNo;
	private Date oDate;
	private int oTotalPrice;
	
	private User user;
	private List<User> userList;
	private List<Order> orderList;
	private List<OrderItem> orderItemList;
}
