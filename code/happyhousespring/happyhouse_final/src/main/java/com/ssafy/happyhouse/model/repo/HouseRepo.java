package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.HousePageBean;


public interface HouseRepo {
		
	public List<HousePageBean> searchDong(String dong);
	
	public List<HousePageBean> searchAptName(String aptName);
}
