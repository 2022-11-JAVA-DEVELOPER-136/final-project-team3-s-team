package com.itwill.steam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.itwill.steam.card.mapper",
							"com.itwill.steam.cart.mapper",
							"com.itwill.steam.category.mapper",
							"com.itwill.steam.chat.mapper",
							"com.itwill.steam.user.mapper",
							"com.itwill.steam.game.mapper",
							"com.itwill.steam.order.mapper",
							"com.itwill.steam.review.mapper",
							"com.itwill.steam.friend.mapper"})
public class FinalProjectTeam3STeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam3STeamApplication.class, args);
	}

}
