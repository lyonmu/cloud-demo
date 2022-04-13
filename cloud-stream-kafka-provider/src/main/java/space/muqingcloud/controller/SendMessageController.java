package space.muqingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.SendMessageService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SendMessageController {
    @Resource
    SendMessageService service;

    @GetMapping("/send/message/{id}")
    ResponseResult<String> sendMessage(@PathVariable("id") Long id) {
        ResponseResult<String> result = service.send(id);
        return result;
    }
}
