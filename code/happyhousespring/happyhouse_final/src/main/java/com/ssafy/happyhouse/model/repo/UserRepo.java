package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.User;

public interface UserRepo {
	
	public User userInfo(String id);
	
	public int userDelete(String id);
	
	public int userModify(User user);
	
	public int userRegister(User user);
	
	public List<User> userList();

}
