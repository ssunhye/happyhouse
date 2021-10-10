package com.ssafy.happyhouse.dto;

import java.util.List;

public class QnA {
	
	private int num;
	private String id;
	private String name;
	private String title;
	private String content;
	private int lookup, commentcount;
	private String date;
	
	public QnA() {}
	
	public QnA(int num, String id, String name, String title, String content, int lookup, int commentcount,
			String date) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.lookup = lookup;
		this.commentcount = commentcount;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getLookup() {
		return lookup;
	}

	public void setLookup(int lookup) {
		this.lookup = lookup;
	}

	public int getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
