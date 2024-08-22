package com.wangguangwu.usermodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.wangguangwu.usermodule.mapper")
public class UserModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserModuleApplication.class, args);
	}

}
