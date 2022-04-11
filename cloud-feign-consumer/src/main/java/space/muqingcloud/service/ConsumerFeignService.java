package space.muqingcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.entities.User;

import java.util.List;

@Service
@FeignClient(value = "SYSTEM-USER")
public interface ConsumerFeignService {
    @GetMapping("/users")
    ResponseResult<List<User>> selectAll();
}
