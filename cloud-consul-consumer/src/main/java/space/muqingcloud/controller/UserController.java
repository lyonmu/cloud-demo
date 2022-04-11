package space.muqingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {
    public static final String USER_URL = "http://cloud-consul-user";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/user/consul")
    public String paymentConsul() {
        String forObject = restTemplate.getForObject(USER_URL + "/user/consul", String.class);
        log.info(forObject);
        return forObject;
    }
}
