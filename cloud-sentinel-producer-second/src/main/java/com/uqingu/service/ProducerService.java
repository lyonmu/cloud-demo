package com.uqingu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import space.muqingcloud.entities.ResponseResult;

@Service
public class ProducerService {

    @Value("${server.port}")
    private String port;

    public ResponseResult<String> getTest(Long id) {

        if (id > 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (id < 2) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return new ResponseResult<>(200, "测试sentinel", port, "测试@SentinelResource注解，ID为：" + id);
    }
}
