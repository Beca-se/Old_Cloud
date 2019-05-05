package com.zh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Zhou Hu
 * @Description: Spring 主启动类
 * @Date: 16:18 2019-05-05
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}