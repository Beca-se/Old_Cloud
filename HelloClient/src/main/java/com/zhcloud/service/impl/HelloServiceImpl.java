package com.zhcloud.service.impl;

import com.zhcloud.domain.RestBean;
import com.zhcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhou Hu
 * @Description: 实现HelloService中方法的具体实现
 * @Date: 13:52 2019-05-05
 **/

@Service
@RefreshScope
public class HelloServiceImpl implements HelloService {

    @Value("${name}")
    private String name;

    @Override
    public RestBean hello(String name) {
        RestBean<String> restBean = new RestBean<>();
        System.out.println(System.currentTimeMillis() + "======" + name);
        try {
            restBean.setCode(900000);
            restBean.setMessage("SUCCESS");
            restBean.setData("Hello " + name + " , I'm " + this.name);
        } catch (Exception e) {
            restBean.setCode(999999);
            restBean.setMessage(e.getMessage());
        }
        return restBean;
    }
}