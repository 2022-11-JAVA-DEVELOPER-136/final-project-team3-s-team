package com.itwill.steam.resources;

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
public class Resources {
	private int resNo;
	private String resName;
	
	private int gNo;//Resources객체에서 Game객체의 방향으로 접근할 일이 없다고 생각해서 FK만 기술.
}