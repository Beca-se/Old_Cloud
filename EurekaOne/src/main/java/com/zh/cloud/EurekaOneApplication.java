package com.zh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: Zhou Hu
 * @Description: Spring boot 启动类 加上{@link EnableEurekaServer} 表明这个 Application 是一个 Eureka Server
 * @Date: 10:21 2019-05-05
 **/

@SpringBootApplication
@EnableEurekaServer
public class EurekaOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOneApplication.class, args);
    }
}