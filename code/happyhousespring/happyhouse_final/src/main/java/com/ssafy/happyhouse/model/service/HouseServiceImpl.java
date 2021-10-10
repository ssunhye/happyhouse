package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.model.repo.HouseRepo;

@Service
public class HouseServiceImpl implements HouseService {
	
	private HouseRepo repo;
	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public void setHouseRepo(HouseRepo repo) {
		this.repo = repo;
	}

	public HouseRepo getHouseRepo() {
		return repo;
	}

	@Override
	public List<HousePageBean> searchDong(String dong) {
		return sqlSession.getMapper(HouseRepo.class).searchDong(dong);
	}

	@Override
	public List<HousePageBean> searchAptName(String aptName) {
		return sqlSession.getMapper(HouseRepo.class).searchAptName(aptName);
	}
	

}
