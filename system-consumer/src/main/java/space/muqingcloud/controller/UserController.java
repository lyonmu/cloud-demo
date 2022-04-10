package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.entities.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class UserController {
    public static final String USER_URL = "http://SYSTEM-USER";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/users")
    ResponseResult<List<User>> selectAll() {
        ResponseResult forObject = null;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        try {
            forObject = poolExecutor.submit(() -> restTemplate.getForObject(USER_URL + "/users", ResponseResult.class)).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
        if (forObject == null) {
            forObject = new ResponseResult(500, "服务器发生错误", null);
        }
        log.info(JSON.toJSONString(forObject));
        return forObject;
    }
}
