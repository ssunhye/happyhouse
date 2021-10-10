package com.ssafy.happyhouse.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ssafy.happyhouse.model.repo.UserRepo;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackageClasses = UserRepo.class)
@EnableTransactionManagement
public class ApplicationConfig {
}
