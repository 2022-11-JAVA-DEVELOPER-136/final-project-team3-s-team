package com.itwill.steam.tag;

import java.util.List;

import com.itwill.steam.gameTag.GameTag;
import com.itwill.steam.newsTag.NewsTag;

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
public class Tag {
	private int tagNo;
	private String tagName;
	
	private List<GameTag> gameTagList;
	private List<NewsTag> newsTagList;
}