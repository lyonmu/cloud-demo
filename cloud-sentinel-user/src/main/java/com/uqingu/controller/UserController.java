package com.uqingu.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;

@RestController
@Slf4j
public class UserController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/sentinela")
    public ResponseResult<String> discovery() {
        ResponseResult<String> result = new ResponseResult<>(200, "测试sentinel", serverPort, "测试sentinel的第一个接口");
        log.info(JSON.toJSONString(result));
        return result;
    }

    @GetMapping("/sentinelb")
    public ResponseResult<String> discovery2() {
        ResponseResult<String> result = new ResponseResult<>(200, "测试sentinel", serverPort, "测试sentinel的第二个接口");
        log.info(JSON.toJSONString(result));
        return result;
    }
}
