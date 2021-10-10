package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Comments;
import com.ssafy.happyhouse.model.repo.CommentsRepo;

@Service
public class CommentsServiceImpl implements CommentsService {

	private CommentsRepo repo;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setCommentsRepo(CommentsRepo repo ) {
		this.repo = repo;
	}
	public CommentsRepo getCommentsRepo() {
		return repo;
	}

	@Override
	public List<Comments> commentsSelect(int qna_num) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CommentsRepo.class).commentsSelect(qna_num);
	}

	@Override
	public boolean commentsCreate(Comments comments) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CommentsRepo.class).commentsCreate(comments)==1;
	}

	@Override
	public boolean commentsModify(Comments comments) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CommentsRepo.class).commentsModify(comments)==1;
	}

	@Override
	public boolean commentsDelete(int num) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CommentsRepo.class).commentsDelete(num)==1;
	}

}
