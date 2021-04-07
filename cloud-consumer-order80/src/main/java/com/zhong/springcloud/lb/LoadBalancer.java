package com.zhong.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    //ServiceInstance 表示 发现服务实例
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
