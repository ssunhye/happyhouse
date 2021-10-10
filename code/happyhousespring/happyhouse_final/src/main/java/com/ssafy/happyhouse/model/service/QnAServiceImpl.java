package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.model.repo.QnARepo;

@Service
public class QnAServiceImpl implements QnAService {

	private QnARepo repo;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setQnARepo(QnARepo repo ) {
		this.repo = repo;
	}
	public QnARepo getQnARepo() {
		return repo;
	}
	
	@Override
	public List<QnA> qnaList() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).qnaList();
	}

	@Override
	public List<QnA> searchqnaList(String word) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).searchqnaList(word);
	}

	@Override
	public QnA qnaSelect(int num) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).qnaSelect(num);
	}

	@Override
	public boolean qnaCreate(QnA qna) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).qnaCreate(qna)==1;
	}

	@Override
	public boolean qnaModify(QnA qna) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).qnaModify(qna)==1;
	}

	@Override
	public boolean qnaDelete(int num) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnARepo.class).qnaDelete(num)==1;
	}

}
