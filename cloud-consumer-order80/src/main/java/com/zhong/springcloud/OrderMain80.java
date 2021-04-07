package com.zhong.springcloud;

import com.zhong.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //
//@RibbonClient(name = "CLOUD_PAYMENT_SERVICE",configuration = MySelfRule.class)//访问 name的服务
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class,args);
    }

}
//  http://localhost/consumer/payment/get/2







