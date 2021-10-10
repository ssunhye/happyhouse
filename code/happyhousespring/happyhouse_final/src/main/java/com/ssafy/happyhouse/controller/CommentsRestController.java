package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Comments;
import com.ssafy.happyhouse.model.service.CommentsService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/comments")
public class CommentsRestController {
	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	CommentsService cservice;
	
	@ApiOperation(value = "글의 댓글 정보를 반환한다.", response = List.class)
	@GetMapping("{qna_num}")
	public ResponseEntity<List<Comments>> commentsSelect(@PathVariable("qna_num") int qna_num) {
		logger.debug("commentsSelect - 호출");
		return new ResponseEntity<>(cservice.commentsSelect(qna_num), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> coomentsCreate(@RequestBody Comments comments) {
		logger.debug("coomentsCreate- 호출");
		if(cservice.commentsCreate(comments)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "댓글을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{num}")
	public ResponseEntity<String> commentsModify(@RequestBody Comments comments) {
		logger.debug("commentsModify - 호출");
		if(cservice.commentsModify(comments)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "댓글을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{num}")
	public ResponseEntity<String> commentsDelete(@PathVariable("num") int num) {
		logger.debug("commentsDelete - 호출");
		if(cservice.commentsDelete(num)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
