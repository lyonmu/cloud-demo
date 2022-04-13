package space.muqingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;

@RestController
@Slf4j
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/user/discovery/{id}")
    public ResponseResult<String> discovery(@PathVariable("id") Long id) {
        ResponseResult<String> result = new ResponseResult<>(200, "测试nacos的服务发现与注册", serverPort, "测试nacos的服务发现与注册");
        return result;
    }
}
