package com.center.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shaonan.hu
 * @version V1.0
 * @Time 2019/8/22
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.center.user"})
public class MallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class, args);
    }
}
