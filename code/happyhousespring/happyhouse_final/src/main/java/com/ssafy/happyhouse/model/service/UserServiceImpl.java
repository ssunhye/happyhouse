package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SqlSession sqlSession;
	
	private UserRepo userRepo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User userInfo(String id) {
		return userRepo.userInfo(id);
	}

	@Override
	public boolean userDelete(String id) {
		return sqlSession.getMapper(UserRepo.class).userDelete(id)==1;
	}

	@Override
	public boolean userModify(User user) {
		return sqlSession.getMapper(UserRepo.class).userModify(user)==1;
	}

	@Override
	public boolean userRegister(User user) {
		return sqlSession.getMapper(UserRepo.class).userRegister(user)==1;
	}

	@Override
	public List<User> userList() {
		return sqlSession.getMapper(UserRepo.class).userList();
	}

}
