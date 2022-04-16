package space.muqingcloud.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.UserService;

@Component
public class UserServiceFallbackClass implements UserService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public ResponseResult<String> userInfoSuccess() {
        ResponseResult<String> result = new ResponseResult<>(200, "消费端实现Fallback成功的结果", serverPort, "消费端实现Fallback成功的线程：" + Thread.currentThread().getName());
        return result;
    }

    @Override
    public ResponseResult<String> userInfoTimeout() {
        ResponseResult<String> result = new ResponseResult<>(200, "消费端实现Fallback超时成功的结果", serverPort, "消费端实现Fallback超时成功的线程：" + Thread.currentThread().getName());
        return result;
    }
}
