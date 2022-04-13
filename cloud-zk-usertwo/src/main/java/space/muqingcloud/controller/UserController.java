package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
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
    private String port;

    @GetMapping("/zk/user/{id}")
    public ResponseResult<String> getUserZK(@PathVariable("id") Long id) {
        ResponseResult<String> result = new ResponseResult<>(200, "zookeeper注册服务", port, "zookeeper注册user服务");
        log.info(JSON.toJSONString(result));
        return result;
    }
}
