package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.User;

// 사용자의 요청을 처리하는 역할 - Transaction 관리
public interface UserService {

	public User userInfo(String id);
	
	public boolean userDelete(String id);
	
	public boolean userModify(User user);
	
	public boolean userRegister(User user);
	
	public List<User> userList();
}
