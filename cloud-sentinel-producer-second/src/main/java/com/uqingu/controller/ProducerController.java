package com.uqingu.controller;

import com.alibaba.fastjson.JSON;
import com.uqingu.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProducerController {

    @Resource
    private ProducerService producerService;

    @GetMapping("/producer/{id}")
    public ResponseResult<String> getTest(@PathVariable("id") Long id) {
        ResponseResult<String> result = producerService.getTest(id);
        log.info(JSON.toJSONString(result));
        return result;
    }
}
