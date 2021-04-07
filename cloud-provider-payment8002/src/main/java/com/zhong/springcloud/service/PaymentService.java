package com.zhong.springcloud.service;

import com.zhong.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    //写操作
    int create(Payment payment);

    //读操作
    Payment getPaymentById(@Param("id") Long id);


}
