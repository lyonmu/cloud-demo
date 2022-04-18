package com.uqingu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelProducerFirst {
    public static void main(String[] args) {
        SpringApplication.run(SentinelProducerFirst.class, args);
    }
}
