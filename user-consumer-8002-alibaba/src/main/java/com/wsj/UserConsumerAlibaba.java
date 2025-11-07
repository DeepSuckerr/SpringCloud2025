package com.wsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wsj")
public class UserConsumerAlibaba
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserConsumerAlibaba.class,args);
    }
}
