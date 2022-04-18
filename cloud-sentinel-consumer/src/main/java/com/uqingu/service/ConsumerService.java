package com.uqingu.service;

import com.uqingu.service.impl.ConsumerServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import space.muqingcloud.entities.ResponseResult;

@Service
@FeignClient(value = "cloud-sentinel-producer", fallback = ConsumerServiceFallback.class)
public interface ConsumerService {

    @GetMapping("/producer/{id}")
    ResponseResult<String> getTest(@PathVariable("id") Long id);
}
