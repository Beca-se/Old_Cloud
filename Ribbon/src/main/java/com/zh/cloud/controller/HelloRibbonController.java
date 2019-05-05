package com.zh.cloud.controller;

import com.zh.cloud.domain.RestBean;
import com.zh.cloud.service.HelloRibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhou Hu
 * @Description: TODO
 * @Date: 16:22 2019-05-05
 **/

@RestController
public class HelloRibbonController {

    private HelloRibbonService helloRibbonService;

    public HelloRibbonController(HelloRibbonService helloRibbonService) {
        this.helloRibbonService = helloRibbonService;
    }

    @GetMapping("/hello")
    private RestBean hello(String name) {
        return helloRibbonService.hello(name);
    }
}