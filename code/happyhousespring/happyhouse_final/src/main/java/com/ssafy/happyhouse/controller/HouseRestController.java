package com.ssafy.happyhouse.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.model.service.HouseDealService;
import com.ssafy.happyhouse.model.service.HouseService;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/house")
public class HouseRestController {
	private static final Logger logger = LoggerFactory.getLogger(HouseRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	HouseService hservice;
	
	@Autowired
	HouseDealService housedealservice;
	
	@ApiOperation(value = "해당하는 동의 아파트를 가져온다")
	@GetMapping("/dong/{dong}")
	public ResponseEntity<List<HousePageBean>> searchDongList(@PathVariable String dong) {
		logger.debug("searchDongList - 호출");
		return new ResponseEntity<>(hservice.searchDong(dong), HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당하는 이름이 포함된 아파트를 가져온다")
	@GetMapping("/aptname/{aptName}")
	public ResponseEntity<List<HousePageBean>> searchAptName(@PathVariable String aptName) {
		logger.debug("searchAptName - 호출");
		return new ResponseEntity<>(hservice.searchAptName(aptName), HttpStatus.OK);
	}
	
	@Autowired
	RestTemplate restTemplate;

	@ApiOperation(value = "해당하는 정보의 공공데이터를 가져와 삽입한다", response = String.class)
	@GetMapping("/aptdeal/{LAWD_CD}/{DEAL_YMD}")
	public ResponseEntity<String> getAptDealInfo(@PathVariable("LAWD_CD") String LAWD_CD, @PathVariable("DEAL_YMD") String DEAL_YMD)
			throws UnsupportedEncodingException, URISyntaxException, ParseException {
		String url = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade";
//		String serv = "gKGP6MrX0UsJTVHOXH7sMK0ZysaVWD5MYCfT8Rt%2B0Zp8z2teJzuna0P3HkLRAeHhdcDWA%2FXqBEKzR4KiY7nHTw%3D%3D";
		String serv = "5331G6lIyKdGybD0IO6GoIMtu2HkPnfHuTq3fCsQ6PO%2Fz2FkMblb13DvApjKWqTjpk1PAm4j57qPkiQeBoAf7Q%3D%3D";
	        
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("serviceKey", serv)
                .queryParam("LAWD_CD", LAWD_CD)
                .queryParam("DEAL_YMD", DEAL_YMD)
                .build(true);
		
		ResponseEntity<String> result = restTemplate.getForEntity(builder.toUri(), String.class);
		
		List<HouseDeal> housedealList = new ArrayList<>();
		
		JSONParser jsonParse = new JSONParser(); 
		JSONObject jsonObj = (JSONObject) jsonParse.parse(result.getBody());
		JSONObject j_res = (JSONObject) jsonObj.get("response");
		JSONObject j_body = (JSONObject) j_res.get("body");
		JSONObject j_items = (JSONObject) j_body.get("items");
		JSONArray houseArray = (JSONArray) j_items.get("item");
		
		for(int i=0; i < houseArray.size(); i++) { 
			JSONObject houseObject = (JSONObject) houseArray.get(i);
			housedealList.add(new HouseDeal(
					houseObject.get("법정동").toString().trim(),
					houseObject.get("아파트").toString().trim(),
					Integer.parseInt(houseObject.get("지역코드").toString().trim()),
					houseObject.get("거래금액").toString().trim(),
					Integer.parseInt(houseObject.get("건축년도").toString().trim()),
					Integer.parseInt(houseObject.get("년").toString().trim()),
					Integer.parseInt(houseObject.get("월").toString().trim()),
					Integer.parseInt(houseObject.get("일").toString().trim()),
					Double.parseDouble(houseObject.get("전용면적").toString().trim()),
					Integer.parseInt(houseObject.get("층").toString().trim()),
					houseObject.get("지번").toString().trim(),
					"1"));
		}
		
		if(housedealservice.inserthouse(housedealList)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "모든 내용을 초기화", response = String.class)
	@DeleteMapping
	public ResponseEntity<String> delete() {
		if(housedealservice.deletehouse()) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
