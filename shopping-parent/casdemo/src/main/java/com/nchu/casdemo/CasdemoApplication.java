package com.nchu.casdemo;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableCasClient
@SpringBootApplication
public class CasdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasdemoApplication.class, args);
    }

}
