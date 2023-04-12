package com.itwill.steam.newsTag;

import com.itwill.steam.news.News;
import com.itwill.steam.tag.Tag;

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
public class NewsTag {
	private int ntNo;
	
	private Tag tag;
	private News news;
}