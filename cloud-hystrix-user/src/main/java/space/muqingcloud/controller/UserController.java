package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.ServiceCircuitBreaker;
import space.muqingcloud.service.UserService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @Resource
    ServiceCircuitBreaker serviceCircuitBreaker;

    @GetMapping("/hystrix/user/info/success")
    public ResponseResult<String> userInfoSuccess() {
        ResponseResult<String> result = userService.userInfoSuccess();
        log.info(JSON.toJSONString(result));
        return result;
    }

    @GetMapping("/hystrix/user/info/timeout")
    public ResponseResult<String> userInfoTimeout() {
        ResponseResult<String> result = userService.userInfoTimeout();
        log.info(JSON.toJSONString(result));
        return result;
    }

    @GetMapping("/service/circuit/{id}")
    public ResponseResult<String> paymentCircuitBreaker(@PathVariable("id") Integer id) {
        ResponseResult<String> result = serviceCircuitBreaker.paymentCircuitBreaker(id);
        log.info(JSON.toJSONString(result));
        return result;
    }
}
