package com.zh.cloud.service.impl;

import com.zh.cloud.domain.RestBean;
import com.zh.cloud.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Zhou Hu
 * @Description: TODO
 * @Date: 16:24 2019-05-05
 **/

@Service
public class HelloRibbonServiceImpl implements HelloRibbonService {
    private RestTemplate restTemplate;

    @Value("${instance.name}")
    private String instanceName;

    public HelloRibbonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RestBean hello(String name) {
        String url = "http://" + instanceName + "/hello";
        RestBean restBean = new RestBean();
        HttpHeaders headers = new HttpHeaders();
        headers.add("name", "zhouhu");
        // MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        // HttpEntity<MultiValueMap<String, String>> r = new HttpEntity<>(requestEntity, headers);
        try {
            String forEntity = restTemplate.getForObject(url, String.class, headers);
            restBean.setCode(9000000);
            restBean.setMessage("SUCCESS");
            restBean.setData(forEntity);
        } catch (Exception e) {
            restBean.setCode(999999);
            restBean.setMessage(e.getMessage());
        }
        return restBean;
    }
}