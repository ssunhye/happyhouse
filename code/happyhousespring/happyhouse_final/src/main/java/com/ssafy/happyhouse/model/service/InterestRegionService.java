package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.InterestRegion;


public interface InterestRegionService{
	public boolean insert(InterestRegion ir);
	
	public boolean delete(String id, String gu);
		
	public List<InterestRegion> list(String id);
	
	public List<InterestRegion> totalList();
}
