package space.muqingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import space.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 服务发现与注册注解
@RibbonClient(name = "SYSTEM-USER", configuration = MySelfRule.class)
public class MainConsumerOperation {
    public static void main(String[] args) {
        SpringApplication.run(MainConsumerOperation.class, args);
    }
}
