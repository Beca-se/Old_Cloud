package com.zhcloud.controller;

import com.zhcloud.domain.RestBean;
import com.zhcloud.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhou Hu
 * @Description: RestFul 风格接口
 * @Date: 13:50 2019-05-05
 **/

@RestController
public class HelloController {


    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    private RestBean hello(String name) {
        return helloService.hello(name);
    }
}