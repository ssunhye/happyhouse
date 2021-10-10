package com.ssafy.happyhouse.dto;

public class InterestRegion {
	private String id;
	private String gu;

	public InterestRegion() {
		super();
	}

	public InterestRegion(String id, String gu) {
		super();
		this.id = id;
		this.gu = gu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}
	
	
}
