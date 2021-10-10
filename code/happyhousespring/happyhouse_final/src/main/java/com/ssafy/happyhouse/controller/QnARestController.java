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

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.model.service.QnAService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnARestController {
	
	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	QnAService qservice;
	
	@ApiOperation(value = "qna글 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> qnaList() {
		logger.debug("qnaList - 호출");
		return new ResponseEntity<>(qservice.qnaList(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "단어가 포함된 qna글 정보를 반환한다.", response = List.class)
	@GetMapping("search/{word}")
	public ResponseEntity<List<QnA>> searchqnaList(@PathVariable("word") String word) {
		logger.debug("commentsSelect - 호출");
		return new ResponseEntity<>(qservice.searchqnaList(word), HttpStatus.OK);
	}
	
	@ApiOperation(value = "선택한 qna글 정보를 반환한다.", response = List.class)
	@GetMapping("select/{num}")
	public ResponseEntity<QnA> qnaSelect(@PathVariable("num") int num) {
		logger.debug("qnaSelect - 호출");
		return new ResponseEntity<>(qservice.qnaSelect(num), HttpStatus.OK);
	}

	@ApiOperation(value = "qna글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> qnaCreate(@RequestBody QnA qna) {
		logger.debug("qnaCreate- 호출");
		if(qservice.qnaCreate(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "qna글을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{num}")
	public ResponseEntity<String> qnaModify(@RequestBody QnA qna) {
		logger.debug("qnaModify - 호출");
		if(qservice.qnaModify(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "qna글을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{num}")
	public ResponseEntity<String> commentsDelete(@PathVariable("num") int num) {
		logger.debug("qnaDelete - 호출");
		if(qservice.qnaDelete(num)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
