package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.InterestRegion;

public interface InterestRegionRepo {
	public int insert(InterestRegion ir);
	
	public int delete(String id, String gu);
		
	public List<InterestRegion> list(String id);
	
	public List<InterestRegion> totalList();
}
