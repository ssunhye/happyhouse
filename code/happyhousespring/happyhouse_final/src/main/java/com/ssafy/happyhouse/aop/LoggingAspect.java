package com.ssafy.happyhouse.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(  * com.ssafy.happyhouse.model..*.*(..))")
	public void logging(JoinPoint jp) {
		logger.debug("메서드 호출됨: 메서드 선언부: {}, 전달된 파라미터: {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
}
