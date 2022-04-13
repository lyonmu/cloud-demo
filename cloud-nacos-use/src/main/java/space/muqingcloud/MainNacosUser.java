package space.muqingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainNacosUser {
    public static void main(String[] args) {
        SpringApplication.run(MainNacosUser.class, args);
    }
}
