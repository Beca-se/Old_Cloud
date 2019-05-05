package com.zhcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Zhou Hu
 * @Description: Spring boot 主启动类,{@link EnableEurekaClient}表明自己是一个Eureka Client,{@link EnableDiscoveryClient}表明自己可以发现其他实例,主要用来抓取Config Server
 * @Date: 13:50 2019-05-05
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class HelloClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }
}