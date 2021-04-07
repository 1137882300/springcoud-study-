package com.zhong.springcloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
// @Bean 类似于
// applicationContext.xml <bean id="" class="" >

    @Bean
//    @LoadBalanced //负载均衡 赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }




}











