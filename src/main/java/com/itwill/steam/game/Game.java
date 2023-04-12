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
	private double gDiscountRate;
	private Date gDiscountStart;
	private Date gDiscountEnd;
	private String gOs;
	private String gProsessor;
	private String gMemory;
	private String gGraphic;
	
	// 추가
	private String g_Disk_Space;
	private String g_Min_Prosessor;
	private String g_Min_Memory;
	private String g_Min_Graphic;
	private String g_Min_Disk_Space;
		
	private int gSellCount;
	
	private Category category;
	private List<Resources> resourcesList;
	private List<GameLanguage> gameLanguageList;
	private List<News> newsList;
	private List<GameTag> gameTagList;
	private List<Review> reviewList;
	private List<Workshop> workshopList;
}