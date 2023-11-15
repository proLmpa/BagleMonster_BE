package com.example.baglemonster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BaglemonsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaglemonsterApplication.class, args);
    }

}
