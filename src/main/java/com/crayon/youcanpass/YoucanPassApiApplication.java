package com.crayon.youcanpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class YoucanPassApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoucanPassApiApplication.class, args);
    }

}
