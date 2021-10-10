package com.ssafy.happyhouse.dto;

public class HousePageBean {
	private String  dong;
	private String  aptName;
	private String lat;
	private String lng;
	private double area;
	private String dealAmount;
	private String dealDate;
	
	public HousePageBean() {}

	public HousePageBean(String dong, String aptName, String lat, String lng, double area, String dealAmount, String dealDate) {
		super();
		this.dong = dong;
		this.aptName = aptName;
		this.lat = lat;
		this.lng = lng;
		this.area = area;
		this.dealAmount = dealAmount;
		this.dealDate = dealDate;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	@Override
	public String toString() {
		return "HousePageBean [dong=" + dong + ", aptName=" + aptName + ", lat=" + lat + ", lng=" + lng + ", area="
				+ area + ", dealDay=" + dealDate + "]";
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	
}
