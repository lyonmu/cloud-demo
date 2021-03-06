package space.muqingcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("space.muqingcloud.mapper")
@EnableTransactionManagement
@EnableEurekaClient
public class UserMainOperationTwo {
    public static void main(String[] args) {
        SpringApplication.run(UserMainOperationTwo.class, args);
    }
}
