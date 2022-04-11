package space.muqingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.entities.User;
import space.muqingcloud.service.ConsumerFeignService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Resource
    ConsumerFeignService consumerFeignService;

    @GetMapping("/users")
    ResponseResult<List<User>> selectAll() {
        return consumerFeignService.selectAll();
    }

    @GetMapping("/timeout")
    ResponseResult<String> timeout() {
        return consumerFeignService.timeout();
    }

    ;


}
