package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Article;
import com.ssafy.happyhouse.model.repo.ArticleRepo;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepo repo;
	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setArticleRepo(ArticleRepo repo ) {
		this.repo = repo;
	}
	public ArticleRepo ArticleRepo() {
		return repo;
	}
	
	@Override
	public List<Article> articleList() {
		return sqlSession.getMapper(ArticleRepo.class).articleList();
	}

	@Override
	public Article articleSelect (int num) {
		return sqlSession.getMapper(ArticleRepo.class).articleSelect(num);
	}

	@Override
	public boolean articleCreate(Article article) {
		return sqlSession.getMapper(ArticleRepo.class).articleCreate(article)==1;
	}

	@Override
	public boolean articleModify(Article article) {
		return sqlSession.getMapper(ArticleRepo.class).articleModify(article)==1;
	}

	@Override
	public boolean articleDelete(int num) {
		return sqlSession.getMapper(ArticleRepo.class).articleDelete(num)==1;
	}

}
