package space.muqingcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.util.IpUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/user/discovery/{id}")
    public ResponseResult<String> discovery(@PathVariable("id") Long id, HttpServletRequest request) {
        String ipAdder = IpUtil.getIpAddr(request);
        log.info("请求的IP地址是：" + ipAdder);
        ResponseResult<String> result = new ResponseResult<>(200, "测试nacos的服务发现与注册", serverPort, "测试nacos的服务发现与注册");
        log.info(JSON.toJSONString(result));
        return result;
    }

    @GetMapping("/nacos/user/gateway/{id}")
    public ResponseResult<String> discovery2(@PathVariable("id") Long id, HttpServletRequest request) {
        ResponseResult<String> result = new ResponseResult<>(200, "测试gateway的路由转发", serverPort, "测试gateway的路由转发");
        log.info(JSON.toJSONString(result));
        return result;
    }
}
