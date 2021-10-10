package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;

public interface HouseDealRepo {
	public List<HouseDeal> HouseDealList(String dong,String aptName);

	public int inserthouse(List<HouseDeal> list);
	
	public int deletehouse();
}
