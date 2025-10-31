package com.wsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"com.wsj","com.wsj.apis.config"})
@MapperScan("com.wsj.mapper")
@EnableDiscoveryClient
public class OrderProvider9001Service
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderProvider9001Service.class, args);
    }
}
