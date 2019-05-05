package com.zhcloud.service;

import com.zhcloud.domain.RestBean;

/**
 * @Author: Zhou Hu
 * @Description: Hello 的Service层
 * @Date: 13:51 2019-05-05
 **/

public interface HelloService {

    /**
     * 一个简单的Hello接口,传入一个姓名,然后在姓名前面加上Hello返回
     *
     * @param name 参数
     * @return RestBean
     */
    RestBean hello(String name);
}