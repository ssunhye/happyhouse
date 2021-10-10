package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;

public interface HouseDealService {
	public List<HouseDeal> HouseDealList(String dong,String aptName);
	public boolean inserthouse(List<HouseDeal> list);
	
	public boolean deletehouse();
}
