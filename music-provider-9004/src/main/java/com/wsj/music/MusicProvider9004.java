package com.wsj.music;

import lombok.Setter;
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
public class MusicProvider9004
{
    public static void main( String[] args )
    {
        SpringApplication.run(MusicProvider9004.class, args);
    }
}
