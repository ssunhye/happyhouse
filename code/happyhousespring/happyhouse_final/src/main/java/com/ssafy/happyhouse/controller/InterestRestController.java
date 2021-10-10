package com.ssafy.happyhouse.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.dto.Article;
import com.ssafy.happyhouse.dto.InterestRegion;
import com.ssafy.happyhouse.model.service.InterestRegionService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/interest")
public class InterestRestController {
	private static Logger logger = LoggerFactory.getLogger(InterestRestController.class);
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	InterestRegionService interestService;
	
	@ApiOperation(value = "관심 지역을 등록한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertRegion(@RequestBody InterestRegion ir) {
		logger.debug("insertRegion - 호출");
		if(interestService.insert(ir)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{id}/{gu}")
	public ResponseEntity<String> deleteRegion(@PathVariable("id") String id, @PathVariable("gu") String gu) {
		logger.debug("deleteRegion - 호출");
		if(interestService.delete(id, gu)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "관심지역 리스트를 반환한다.",response = List.class)
	@GetMapping("/{id}")
	public ResponseEntity<List<InterestRegion>> interestList(@PathVariable String id) {
		logger.debug("interestList - 호출");
		return new ResponseEntity<>(interestService.list(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "전체 유저들의 관심지역 리스트를 반환한다.",response = List.class)
	@GetMapping
	public ResponseEntity<List<InterestRegion>> totalList() {
		logger.debug("totalList - 호출");
		return new ResponseEntity<>(interestService.totalList(), HttpStatus.OK);
	}
}
