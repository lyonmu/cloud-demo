package space.muqingcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

@Service
public class ServiceCircuitBreaker {

    @Value("${server.port}")
    private String serverPort;

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public ResponseResult<String> paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id负数异常");
        }
        String serialNumber = IdUtil.simpleUUID();
        ResponseResult<String> result = new ResponseResult<>(200, "调用成功", serverPort, "流水号: " + serialNumber);
        return result;
    }

    public ResponseResult<String> paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        ResponseResult<String> result = new ResponseResult<>(200, "请稍后再试，/(ㄒoㄒ)/~~", serverPort, "id 不能负数，id: " + id);
        return result;
    }
}
