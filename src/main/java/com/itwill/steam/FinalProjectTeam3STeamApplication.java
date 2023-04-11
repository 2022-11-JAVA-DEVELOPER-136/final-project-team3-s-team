package com.itwill.steam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.itwill.steam.card.mapper",
							"com.itwill.steam.cart.mapper",
							"com.itwill.steam.category.mapper",
							"com.itwill.steam.chat.mapper",
							"com.itwill.steam.chatRoom.mapper",
							"com.itwill.steam.friend.mapper",
							"com.itwill.steam.game.mapper",
							"com.itwill.steam.gameLanguage.mapper",
							"com.itwill.steam.gameTag.mapper",
							"com.itwill.steam.language.mapper",
							"com.itwill.steam.news.mapper",
							"com.itwill.steam.newsComment.mapper",
							"com.itwill.steam.newsTag.mapper",
							"com.itwill.steam.order.mapper",
							"com.itwill.steam.orderItem.mapper",
							"com.itwill.steam.ownedGame.mapper",
							"com.itwill.steam.profileComment.mapper",
							"com.itwill.steam.resources.mapper",
							"com.itwill.steam.review.mapper",
							"com.itwill.steam.tag.mapper",
							"com.itwill.steam.user.mapper",
							"com.itwill.steam.wishList.mapper",
							"com.itwill.steam.workshop.mapper"})
public class FinalProjectTeam3STeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam3STeamApplication.class, args);
	}

}
