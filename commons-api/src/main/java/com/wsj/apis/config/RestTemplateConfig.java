package com.wsj.apis.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Spring提供用来调用远程服务的组件RestTemplate
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @Bean 指定的对象交给Spring容器管理
     * @LoadBalanced 负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }

}
