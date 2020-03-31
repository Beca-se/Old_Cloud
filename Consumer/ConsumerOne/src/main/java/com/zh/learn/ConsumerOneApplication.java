package com.zh.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZhouHu
 * @Class Name ConsumerOneApplication
 * @Desc TODO
 * @create: 2020-03-30 17:31
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOneApplication.class, args);
    }
}
