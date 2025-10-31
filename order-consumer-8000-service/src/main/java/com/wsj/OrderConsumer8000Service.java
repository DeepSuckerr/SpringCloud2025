package com.wsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.wsj","com.wsj.apis.config"})
@EnableDiscoveryClient
public class OrderConsumer8000Service {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer8000Service.class, args);
    }
}