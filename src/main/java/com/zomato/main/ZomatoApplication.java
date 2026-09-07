package com.zomato.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zomato")
public class ZomatoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZomatoApplication.class, args);
    }
}