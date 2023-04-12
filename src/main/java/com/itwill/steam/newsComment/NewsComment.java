package com.itwill.steam.newsComment;

import java.util.Date;

import com.itwill.steam.news.News;
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
public class NewsComment {
	private int ncNo;
	private Date ncCreatedAt;
	private String ncComment;
	
	private User user;//코멘트 작성자
	private News news;
}