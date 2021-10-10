package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HousePageBean;

public interface HouseService {
	public List<HousePageBean> searchDong(String dong);
	
	public List<HousePageBean> searchAptName(String aptName);
}
