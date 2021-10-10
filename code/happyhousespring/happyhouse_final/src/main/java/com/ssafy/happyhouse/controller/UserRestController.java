package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Article;
import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/user")
@Slf4j
public class UserRestController {
	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtService jwtService;

	// 로그인
	@ApiOperation(value = "해당 아이디의 비밀번호가 맞는지 확인한다. 그리고 비밀번호 여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user, HttpServletResponse res) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			User loginUser = userService.userInfo(user.getId());
			if (loginUser!= null && loginUser.getPass().equals(user.getPass())) {
				// 로그인 성공
				String token = jwtService.create(loginUser);
	            res.setHeader("jwt-auth-token", token);
	            
	            resultMap.put("status", true);
	            resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			}
		} catch (RuntimeException e) {
			logger.error("로그인 실패", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 회원 가입
	@ApiOperation(value = "회원 등록한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> regist(@RequestBody User user) {
		logger.debug("userRegist - 호출");
		if(userService.userRegister(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	// 회원 정보 수정
	@ApiOperation(value = "정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> modify(@RequestBody User user) {
		logger.debug("userModify - 호출");
		if(userService.userModify(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	// 탈퇴
	@ApiOperation(value = "정보를 삭제한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		logger.debug("userDelete - 호출");
		if(userService.userDelete(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	// 전체 회원 조회
	@ApiOperation(value = "모든 유저들의 정보를 반환한다.", response = List.class)
	@GetMapping("/admin")
	public ResponseEntity<List<User>> userList() {
		logger.debug("userList - 호출");
		return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
	}
	
	
}
