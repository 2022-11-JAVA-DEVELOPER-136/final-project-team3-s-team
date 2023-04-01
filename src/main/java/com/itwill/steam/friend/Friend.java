package com.itwill.steam.friend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friend {
/*
 * 이름      널?       유형         
------- -------- ---------- 
F_NO    NOT NULL NUMBER(10) 
F_STATE          NUMBER(10) 
U_TO             NUMBER(10) 
U_FROM           NUMBER(10) 
 */
	private int fNo;
	private int fState;
	private int uTo;
	private int uFrom;
	
	
	
}
