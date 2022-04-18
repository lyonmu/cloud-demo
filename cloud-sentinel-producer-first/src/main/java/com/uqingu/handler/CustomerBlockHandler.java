package com.uqingu.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

public class CustomerBlockHandler {

    @Value("${server.port}")
    public static String port;

    public static ResponseResult<String> handlerOne(BlockException exception) {
        return new ResponseResult<>(222, "自定义sentinel服务降级处理", port, "自定义sentinel服务降级处理方法二");
    }

    public static ResponseResult<String> handlerTwo(@PathVariable("id") Long id,BlockException exception) {
        return new ResponseResult<>(222, "自定义sentinel服务降级处理", port, "自定义sentinel服务降级处理方法一");
    }
}
