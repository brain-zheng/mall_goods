package com.mall.goodscenter.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(value = "com.mall.goodscenter.dal.dao")
@ComponentScan(value = "com.mall.goodscenter")
@ImportResource(value = {"classpath:dubbo.xml"})
public class GoodsCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsCenterServerApplication.class, args);
    }

}
