package com.wsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserProviderAlibaba9002
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserProviderAlibaba9002.class, args);
    }
}
