package com.uqingu.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

@Slf4j
public class MyFallback {

    public static ResponseResult<String> myTestFallback(@PathVariable Long id, Throwable e) {

        log.info("出现异常触发服务Fallback，具体异常信息为：" + e.getMessage());
        return new ResponseResult<>(333, "测试Fallback", "7071", "使用自定义的类中的Fallback来处理异常，异常为：" + e.getMessage());
    }
}
