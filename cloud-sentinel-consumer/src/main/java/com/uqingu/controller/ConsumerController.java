package com.uqingu.controller;

import com.alibaba.fastjson.JSON;
import com.uqingu.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private ConsumerService consumerService;

    @GetMapping("/consumer/{id}")
    ResponseResult<String> getTest(@PathVariable("id") Long id) {
        ResponseResult<String> result = consumerService.getTest(id);
        log.info(JSON.toJSONString(result));
        return result;
    }
}
