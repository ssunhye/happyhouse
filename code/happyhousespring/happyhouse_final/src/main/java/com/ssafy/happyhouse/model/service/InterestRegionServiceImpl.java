package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.InterestRegion;
import com.ssafy.happyhouse.model.repo.InterestRegionRepo;


@Service
public class InterestRegionServiceImpl implements InterestRegionService{
	
	private InterestRegionRepo repo;
	
	@Autowired
	ResourceLoader resLoader;

	@Autowired
	public void setUserAttenRegionRepo(InterestRegionRepo repo) {
		this.repo = repo;
	}

	public InterestRegionRepo getUserAttenRegionRepo() {
		return repo;
	}
	
	@Override
	public boolean insert(InterestRegion ir) {
		return repo.insert(ir)==1;
	}

	@Override
	public boolean delete(String id, String gu) {
		return repo.delete(id,gu)==1;
	}

	@Override
	public List<InterestRegion> list(String id) {
		return repo.list(id);
	}

	@Override
	public List<InterestRegion> totalList() {
		return repo.totalList();
	}
	
}
