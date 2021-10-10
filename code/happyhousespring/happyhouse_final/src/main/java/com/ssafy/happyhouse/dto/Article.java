package com.ssafy.happyhouse.dto;

public class Article {

	private int num;
	private String name;
	private String title;
	private String content;
	private String date;
	
	public Article() {}
	
	public Article(int num,String name, String title, String content) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.content = content;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
