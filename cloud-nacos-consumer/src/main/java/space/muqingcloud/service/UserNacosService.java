package space.muqingcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

@Service
@FeignClient(value = "cloud-nacos-user")
public interface UserNacosService {
    @GetMapping("/nacos/user/discovery/{id}")
    ResponseResult<String> discovery(@PathVariable("id") Long id);
}
