package com.imooc.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//项目启动类
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mall.dao") //扫描
public class MallApplication {

    public static void main(String[] args) {

        SpringApplication.run(MallApplication.class, args);
    }

}
