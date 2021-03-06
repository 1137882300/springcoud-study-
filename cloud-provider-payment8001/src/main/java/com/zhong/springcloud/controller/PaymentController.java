package com.zhong.springcloud.controller;

import com.zhong.springcloud.entities.CommonResult;
import com.zhong.springcloud.entities.Payment;
import com.zhong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient; //有了这个，就可以获取注册上去的那些服务信息


    //写操作
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){//@RequestBody 不能忘记加上
        int result = paymentService.create(payment);
        log.info("*******插入结果："+result);

        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort: "+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    //读操作
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果："+payment+"\t"+"~~");

        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort: "+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach((e)->{
            log.info("***********e: "+e);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach((e)->{
            log.info(e.getInstanceId()+"\t" +e.getHost()+"\t" +e.getPort()+"\t"+ e.getUri());
        });

        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    /*
    故意写的暂停
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
