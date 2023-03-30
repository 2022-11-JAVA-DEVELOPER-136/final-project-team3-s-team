package com.itwill.steam.language;

import java.util.List;

import com.itwill.steam.gameLanguage.GameLanguage;

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
public class Language {
	private int langNo;
	private String langName;
	
	private List<GameLanguage> gameLanguageList;
}