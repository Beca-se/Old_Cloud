package com.zh.learn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouHu
 * @Class Name FeignLogConfig
 * @Desc TODO
 * @create: 2020-03-30 19:09
 **/
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
