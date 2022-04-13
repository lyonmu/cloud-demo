package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.UserService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @Value("${server.port}")
    String serverPort;

    @GetMapping("/consumer/hystrix/user/info/success")
    public ResponseResult<String> userInfoSuccess() {
        ResponseResult<String> result = userService.userInfoSuccess();
        log.info(JSON.toJSONString(result));
        return result;
    }

    @HystrixCommand(fallbackMethod = "userInfoTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/consumer/hystrix/user/info/timeout")
    public ResponseResult<String> userInfoTimeout() {
        ResponseResult<String> result = userService.userInfoTimeout();
        log.info(JSON.toJSONString(result));
        return result;
    }

    public ResponseResult<String> userInfoTimeoutFallbackMethod() {
        ResponseResult<String> result = new ResponseResult<>(200, "消费侧限流测试超时的fallback", serverPort, "消费侧fallback的线程：" + Thread.currentThread().getName());
        log.info(JSON.toJSONString(result));
        return result;
    }
}
