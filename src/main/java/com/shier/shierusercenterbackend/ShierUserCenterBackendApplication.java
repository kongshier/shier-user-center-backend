package com.shier.shierusercenterbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shier.shierusercenterbackend.mapper")
public class ShierUserCenterBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShierUserCenterBackendApplication.class, args);
    }

}
