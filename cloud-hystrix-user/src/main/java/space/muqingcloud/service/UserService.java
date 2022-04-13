package space.muqingcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import space.muqingcloud.entities.ResponseResult;

@Service
public class UserService {

    @Value("${server.port}")
    private String serverPort;

    public ResponseResult<String> userInfoSuccess() {
        ResponseResult<String> result = new ResponseResult<>(200, "限流测试成功的结果", serverPort, "成功的线程：" + Thread.currentThread().getName());
        return result;
    }

    @HystrixCommand(fallbackMethod = "userInfoTimeoutFallbackMethod"/*指定善后方法名*/, commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public ResponseResult<String> userInfoTimeout() {
//        int number = 10 / 0;
        int sleep = 8000;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseResult<String> result = new ResponseResult<>(200, "限流测试超时的结果", serverPort, "超时的线程：" + Thread.currentThread().getName());
        return result;
    }

    public ResponseResult<String> userInfoTimeoutFallbackMethod() {
        ResponseResult<String> result = new ResponseResult<>(200, "限流测试超时的fallback", serverPort, "fallback的线程：" + Thread.currentThread().getName());
        return result;
    }
}
