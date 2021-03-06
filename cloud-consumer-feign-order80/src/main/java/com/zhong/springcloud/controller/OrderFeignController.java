package com.zhong.springcloud.controller;


import com.zhong.springcloud.entities.CommonResult;
import com.zhong.springcloud.entities.Payment;
import com.zhong.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}") //客户端访问的地址
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "consumer/payment/feign/timeout")
    String paymentFeignTimeout() {
        //openFeign-ribbon ，客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }


}
