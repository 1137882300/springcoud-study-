package com.zhong.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by cc on 2021/9/3
 */

@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD: 测试 RT" );
        log.info("testD: 异常比例" );
        int o = 1 / 0;
        return "-----testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE: 异常数" );
        int o = 1 / 0;
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey", fallback = "") //兜底的方法
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        int r = 10 / 0;
        log.info("----testHotKey");
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2 , BlockException e){
        return "---------deal_testHotKey-" + " e : -> " + e;
    }

}

