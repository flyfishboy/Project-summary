package com.nchu.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity

@SpringBootApplication
public class ShopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopWebApplication.class, args);
    }

}
