package com.itwill.steam.game;

import java.util.Date;
import java.util.List;

import com.itwill.steam.category.Category;
import com.itwill.steam.gameLanguage.GameLanguage;
import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.news.News;
import com.itwill.steam.resources.Resources;
import com.itwill.steam.review.Review;
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
	private double gDiscountRate;//할인률
	private Date gDiscountStart;
	private Date gDiscountEnd;
	private String gOs;
	private String gProsessor;
	private String gMemory;
	private String gGraphic;
	private String gDiskSpace;
	private String gMinOs;
	private String gMinProsessor;
	private String gMinMemory;
	private String gMinGraphic;
	private String gMinDiskSpace;
	private int gSellCount;
	
	private Category category;
	private List<Resources> resourcesList;
	private List<GameLanguage> gameLanguageList;
	private List<News> newsList;
	private List<GameTag> gameTagList;
	private List<Review> reviewList;
	private List<Workshop> workshopList;
}