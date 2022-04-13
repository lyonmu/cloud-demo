package space.muqingcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import space.muqingcloud.entities.ResponseResult;
import space.muqingcloud.service.SendMessageService;

import javax.annotation.Resource;

@Slf4j
@EnableBinding(Source.class) //定义消息的推送管道
public class SendMessageServiceImpl implements SendMessageService {

    @Value("${server.port}")
    private String port;

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public ResponseResult<String> send(Long id) {

        ResponseResult<String> result = new ResponseResult<>(200, "测试发送消息到kafka集群：" + id, port, IdUtil.simpleUUID());
        output.send(MessageBuilder.withPayload(result).build());
        log.info(JSON.toJSONString(result));
        return result;
    }
}
