package com.zh.learn.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZhouHu
 * @Class Name ConfigServerOne
 * @Desc Web启动类
 * @create: 2020-03-19 09:49
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerOneApplication.class, args);
    }
}
