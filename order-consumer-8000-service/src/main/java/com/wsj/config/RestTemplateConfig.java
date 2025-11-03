package com.wsj.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    @Primary //多个同类型Bean时，指定首选项
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }

    @Bean(name = "externalRestTemplate")
    public RestTemplate getExternalRestTemplateBean() {
        return new RestTemplate();
    }

}
