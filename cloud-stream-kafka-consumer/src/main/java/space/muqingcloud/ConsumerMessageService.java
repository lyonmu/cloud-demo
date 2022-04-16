package space.muqingcloud;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
@Slf4j
public class ConsumerMessageService {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {

        log.info(message.getPayload());
        System.out.println("消费者:" + serverPort + ",----->接受到的消息: " + message.getPayload() + "\t  port: " + serverPort);
    }
}
