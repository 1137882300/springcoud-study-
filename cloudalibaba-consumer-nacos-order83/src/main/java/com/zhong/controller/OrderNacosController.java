package com.zhong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by cc on 2021/9/2
 */
@RestController
@Slf4j
public class OrderNacosController {


    @Resource
    private RestTemplate restTemplate;

    @Value("${serviceUrl.nacosUserService}")
    private String serverURL;

    @GetMapping(value = "/comsumer/payment/nacos/{id}")
    public  String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id, String.class);
    }

}
