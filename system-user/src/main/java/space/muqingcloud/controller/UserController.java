package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.entities.User;
import space.muqingcloud.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Resource
    UserService userService;
    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @GetMapping("/users")
    ResponseResult<List<User>> selectAll() {
        List<User> users = userService.selectAll();
        ResponseResult<List<User>> responseResult = new ResponseResult<>(200, "查询所有用户信息", serverPort, users);
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }

    @GetMapping("/user/{id}")
    ResponseResult<User> selectOne(@PathVariable("id") Long id) {
        User user = userService.selectOne(id);
        ResponseResult<User> responseResult = new ResponseResult<>(200, "查询ID为" + id + "的用户信息", serverPort, user);
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }

    @PostMapping("/user")
    ResponseResult<User> insert(User user) {
        int i = userService.insert(user);
        ResponseResult<User> responseResult = new ResponseResult<>(200, "添加新的用户", serverPort, user);
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }

    @PutMapping("/user")
    ResponseResult<User> update(User user) {
        int i = userService.update(user);
        ResponseResult<User> responseResult = new ResponseResult<>(200, "修改ID为" + user.getId() + "的用户信息", serverPort, user);
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }

    @DeleteMapping("/user/{id}")
    ResponseResult<User> delete(@PathVariable("id") Long id) {
        User user = userService.selectOne(id);
        ResponseResult<User> responseResult = new ResponseResult<>(200, "删除ID为" + id + "的用户信息", serverPort, user);
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }

    @GetMapping("/timeout")
    ResponseResult<String> timeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseResult<String> responseResult = new ResponseResult<>(200, "超时测试", serverPort, "超时测试");
        log.info(JSON.toJSONString(responseResult));
        return responseResult;
    }
}
