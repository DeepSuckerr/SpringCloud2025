package com.wsj.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI docsOpenApi(){
        return new OpenAPI().info(new Info().title("SpringCloud").description("通用设计RestFull的接口文档").version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("微服务接口文档").url("https://www.baidu.com/"));

    }

    @Bean
    public GroupedOpenApi accountApi(){
        return GroupedOpenApi.builder().group("订单模块")
                .pathsToMatch("/Order/**").build();
    }

}

