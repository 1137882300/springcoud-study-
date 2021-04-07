package com.zhong.springcloud.dao;

import com.zhong.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//推荐用Mapper 这个注解
public interface PaymentDao {


    //写操作
    int create(Payment payment);

    //读操作
    Payment getPaymentById(@Param("id") Long id);

}
