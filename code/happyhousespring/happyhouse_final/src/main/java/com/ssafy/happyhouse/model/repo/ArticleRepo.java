package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.Article;

public interface ArticleRepo {
	List<Article> articleList();
	Article articleSelect(int num);

	int articleCreate(Article article);

	int articleModify(Article article);

	int articleDelete(int num);
}
