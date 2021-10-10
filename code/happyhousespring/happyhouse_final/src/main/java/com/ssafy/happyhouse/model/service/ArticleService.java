package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Article;

public interface ArticleService {
	List<Article> articleList();
	
	Article articleSelect(int num);

	boolean articleCreate(Article article);

	boolean articleModify(Article article);

	boolean articleDelete(int num);
}
