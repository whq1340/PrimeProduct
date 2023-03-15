package com.example.helloword;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapper注解
@MapperScan("com.example.helloword.mapper")
public class HellowordApplication {

    public static void main(String[] args) {

        SpringApplication.run(HellowordApplication.class, args);
    }

}
