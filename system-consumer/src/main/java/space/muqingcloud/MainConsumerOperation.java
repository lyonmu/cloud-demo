package space.muqingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainConsumerOperation {
    public static void main(String[] args) {
        SpringApplication.run(MainConsumerOperation.class, args);
    }
}
