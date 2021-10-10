package com.ssafy.happyhouse.model.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ssafy.happyhouse.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {
	private static Logger logger = LoggerFactory.getLogger(JwtService.class);
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private Long expireMin;
	
	public String create(final User user) {
		logger.trace("time: {}", expireMin);
		final JwtBuilder builder = Jwts.builder();
		// Header 설정
		builder.setHeaderParam("typ",  "JWT");
		// Payload 설정
		builder.setSubject("로그인토큰")
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin))
			.claim("User", user);
		final String jwt = builder.compact();
		logger.debug("토큰 발행: {}", jwt);
		return jwt;
	}
	
	public void checkValid(final String jwt) {
		logger.trace("토큰 점검: {}", jwt);
		Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
	}
	
	public Map<String, Object> get(final String jwt) {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
		} catch (final Exception e) {
			throw new RuntimeException();
		}
		logger.trace("claims: {}", claims);
		return claims.getBody();
	}
}
