package com.zhong.springcloud.serivce;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by cc on 2021/4/15
 */
@Service
public class PaymentService {

    //正常访问，ok的方法
    public String paymentInfo_ok(Integer id){

        return "线程池： "+ Thread.currentThread().getName()+" paymentInfo_ok,id: "+id;
    }


    public String paymentInfo_timeout(Integer id){

        int timeNumber = 3;
        //睡3s
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池： "+ Thread.currentThread().getName()+" paymentInfo_timeout,id: "+id;
    }


}
