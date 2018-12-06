package com.example.kotlinserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.kotlinserver.dao")
public class KotlinserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(KotlinserverApplication.class, args);
    }
}
