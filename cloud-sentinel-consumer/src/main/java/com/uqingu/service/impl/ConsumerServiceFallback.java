package com.uqingu.service.impl;

import com.uqingu.service.ConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import space.muqingcloud.entities.ResponseResult;

@Component
public class ConsumerServiceFallback implements ConsumerService {
    @Value("${server.port}")
    private String port;

    @Override
    public ResponseResult<String> getTest(Long id) {
        return new ResponseResult<>(555, "测试sentinel", port, "OpenFeign的服务降级：" + id);
    }
}
