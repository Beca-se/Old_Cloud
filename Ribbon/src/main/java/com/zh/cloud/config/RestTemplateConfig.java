package com.zh.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Zhou Hu
 * @Description: Ribbon是利用RestTemplate发送请求出去的, 加上 {@link LoadBalanced }就可以实现负载均衡
 * @Date: 16:20 2019-05-05
 **/

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}