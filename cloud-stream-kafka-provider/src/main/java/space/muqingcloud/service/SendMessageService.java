package space.muqingcloud.service;

import space.muqingcloud.entities.ResponseResult;

public interface SendMessageService {
    ResponseResult<String> send(Long id);
}
