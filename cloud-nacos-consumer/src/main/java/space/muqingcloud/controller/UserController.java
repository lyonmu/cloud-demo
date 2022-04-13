package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.UserNacosService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    UserNacosService userService;

    @GetMapping("/consumer/nacos/user/discovery/{id}")
    public ResponseResult<String> discovery(@PathVariable("id") Long id) {
        ResponseResult<String> result = userService.discovery(id);
        log.info(JSON.toJSONString(result));
        return result;
    }
}
