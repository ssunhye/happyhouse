package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.model.repo.HouseDealRepo;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private HouseDealRepo repo;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setHouseDealRepo(HouseDealRepo repo) {
		this.repo = repo;
	}
	
	public HouseDealRepo setHouseDealRepo() {
		return repo;
	}
	@Override
	public List<HouseDeal> HouseDealList(String dong, String aptName) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseDealRepo.class).HouseDealList(dong, aptName);
	}

	@Override
	public boolean inserthouse(List<HouseDeal> list) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseDealRepo.class).inserthouse(list)==1;
	}

	@Override
	public boolean deletehouse() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseDealRepo.class).deletehouse()==1;
	}

}
