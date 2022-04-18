package com.uqingu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.uqingu.fallback.MyFallback;
import com.uqingu.handler.CustomerBlockHandler;
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
    @SentinelResource(value = "producer",
            blockHandlerClass = CustomerBlockHandler.class, // blockHandlerClass自定义的处理sentinel控制台配置违规类
            blockHandler = "handlerTwo", // blockHandler只负责sentinel控制台配置违规，值为具体要使用的方法名
            fallbackClass = MyFallback.class, // 自定义的fallback处理类，用于在抛出异常的时候提供 fallback 处理逻辑
            fallback = "myTestFallback", // fallback处理运行时异常，值为具体使用自定义的fallback处理类中的方法名
            exceptionsToIgnore = {NullPointerException.class} // 配置那些异常不经过sentinel的fallback
    )
    public ResponseResult<String> getTest(@PathVariable("id") Long id) {
        ResponseResult<String> result = producerService.getTest(id);
        log.info(JSON.toJSONString(result));
        return result;
    }

    @GetMapping("/producer/persistence")
    @SentinelResource(value = "persistence",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerOne"
    )
    public ResponseResult<String> Persistence() {
        ResponseResult<String> result = producerService.getTestPersistence();
        log.info(JSON.toJSONString(result));
        return result;
    }

}
