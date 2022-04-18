package com.uqingu.controller;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.uqingu.exception.LeafServerException;
import com.uqingu.exception.NoKeyException;
import com.uqingu.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test/leaf/{key}")
    public Result testLeaf(@PathVariable("key") String key) {
        return get(key, testService.getId(key));
    }

    private Result get(@PathVariable("key") String key, Result id) {
        Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }
        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            throw new LeafServerException(result.toString());
        }
//        return String.valueOf(result.getId());
        return result;
    }
}
