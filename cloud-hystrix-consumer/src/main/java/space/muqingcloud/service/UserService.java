package space.muqingcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.impl.UserServiceFallbackClass;

@Service
@FeignClient(value = "CLOUD-HYSTRIX-USER", fallback = UserServiceFallbackClass.class)
public interface UserService {
    @GetMapping("/hystrix/user/info/success")
    public ResponseResult<String> userInfoSuccess();

    @GetMapping("/hystrix/user/info/timeout")
    public ResponseResult<String> userInfoTimeout();
}
