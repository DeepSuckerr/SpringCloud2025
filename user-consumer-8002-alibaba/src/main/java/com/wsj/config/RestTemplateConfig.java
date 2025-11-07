package com.wsj.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {


        @Bean
        @LoadBalanced
        @Qualifier(value = "restTemplate3")
        public RestTemplate getRestTemplateConfig(){
            return new RestTemplate();
        }


        @Bean
        @Qualifier(value = "restTemplate4")
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }

}
