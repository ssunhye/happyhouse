package com.ssafy.happyhouse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.model.repo.HouseRepo;
import com.ssafy.happyhouse.model.repo.UserRepo;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.UserService;

@SpringBootTest
public class aparttest {
	
	@Autowired
	UserRepo repo;
	@Autowired
	UserService ser;
	
	@Test
	public void testBean() {
		assertNotNull(repo);
		assertNotNull(ser);
	}
	
	@Test
	void searchdongtest() {
		User list = repo.userInfo("ssafy");
		assertNotNull(list);
		
	}
}
