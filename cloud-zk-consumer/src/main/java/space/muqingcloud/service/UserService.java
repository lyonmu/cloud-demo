package space.muqingcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

@Service
@FeignClient(value = "cloud-zk-user")
public interface UserService {
    @GetMapping("/zk/user/{id}")
    ResponseResult<String> getUserZK(@PathVariable("id") Long id);
}
