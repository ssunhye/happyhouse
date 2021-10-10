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

import com.ssafy.happyhouse.dto.Article;
import com.ssafy.happyhouse.model.service.ArticleService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/article")
public class ArticleRestController {
	public static final Logger logger = LoggerFactory.getLogger(ArticleRestController.class);
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	ArticleService articleService;

	@ApiOperation(value = "모든 글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Article>> articleList() {
		logger.debug("articleList - 호출");
		return new ResponseEntity<>(articleService.articleList(), HttpStatus.OK);
	}

	@ApiOperation(value = "해당하는 책의 정보를 반환한다.", response = Article.class)
	@GetMapping("/{num}")
	public ResponseEntity<Article> articleSelect(@PathVariable int num) {
		logger.debug("articleSelect - 호출");
		return new ResponseEntity<>(articleService.articleSelect(num), HttpStatus.OK);
	}

	@ApiOperation(value = "정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> articleList(@RequestBody Article article) {
		logger.debug("articleCreate - 호출");
		if(articleService.articleCreate(article)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{num}")
	public ResponseEntity<String> modify(@RequestBody Article article) {
		logger.debug("articleModify - 호출");
		logger.debug("" + article);
		if(articleService.articleModify(article)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{num}")
	public ResponseEntity<String> delete(@PathVariable("num") int num) {
		logger.debug("articleDelete - 호출");
		if(articleService.articleDelete(num)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
