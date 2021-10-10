package com.ssafy.happyhouse.dto;

public class Comments {
	
	private int num;
	private String id;
	private String name;
	private String comment;
	private int recommend;
	private int qna_id;
	private String date;
	
	public Comments() {}
	public Comments(int num , String id, String name, String comment, int recommend, int qna_id, String date) {
		super();
		this.setNum(num);
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.recommend = recommend;
		this.qna_id = qna_id;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
