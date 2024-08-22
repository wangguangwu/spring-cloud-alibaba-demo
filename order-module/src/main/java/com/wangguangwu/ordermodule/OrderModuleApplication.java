package com.wangguangwu.ordermodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.ordermodule.mapper")
@EnableTransactionManagement
public class OrderModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderModuleApplication.class, args);
    }

}
