package com.itwill.steam.game;

import java.util.Date;
import java.util.List;

import com.itwill.steam.category.Category;
import com.itwill.steam.news.News;
import com.itwill.steam.resources.Resources;
import com.itwill.steam.review.Review;
import com.itwill.steam.tagGame.TagGame;
import com.itwill.steam.workshop.Workshop;

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
public class Game {
	private int gNo;
	private String gName;
	private String gShortDesc;
	private String gLongDesc;
	private int gGrade;
	private Date gReleaseDate;
	private String gDeveloper;
	private String gDistributor;
	private int gPrice;
	private double gDiscountRate;//int타입이면 정수만 입력될텐데 long이나 double타입을 사용해야 하는 것 아닐까?
	private Date gDiscountStart;
	private Date gDiscountEnd;
	private String gOs;
	private String gProsessor;
	private String gMemory;
	private String gGraphic;
	private int gSellCount;
	
	private Category category;
	private List<Resources> resourcesList;
	//language - 회의하고 나서 관계 확정하고 기술
	private List<News> newsList;
	private List<TagGame> tagGameList;//tagGame?? 이름이 마음에 안든다..
	private List<Review> reviewList;
	private List<Workshop> workshopList;
}