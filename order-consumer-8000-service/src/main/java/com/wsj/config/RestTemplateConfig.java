package com.wsj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RestTemplate {

    @Bean  //指定一个对象交给Spring容器进行管理
    public  RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }



}
