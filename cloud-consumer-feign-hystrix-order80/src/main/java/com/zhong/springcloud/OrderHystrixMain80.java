package com.zhong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by cc on 2021/5/20
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
//http://localhost:801/consumer/payment/hystrix/ok/1
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }

}
