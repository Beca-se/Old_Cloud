package com.zh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Zhou Hu
 * @Description: Spring boot 启动类 ,{@link EnableConfigServer} 表明这个这个Application是Config Server,{@link EnableEurekaClient } 表明这个同时是一个Eureka Client,
 * @Date: 11:03 2019-05-05
 **/

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}