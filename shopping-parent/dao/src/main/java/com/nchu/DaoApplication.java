package com.nchu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nchu.mapper")
@SpringBootApplication
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

}
