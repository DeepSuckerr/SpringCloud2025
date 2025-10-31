package com.wsj.apis.config;

import com.wsj.apis.commons.Swagger3Properties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Knife4jConfig {

    private final Swagger3Properties swagger3Properties;

    public Knife4jConfig(Swagger3Properties swagger3Properties) {
        this.swagger3Properties = swagger3Properties;
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info() // 基本信息配置
                        .title(swagger3Properties.getTitle()) // 标题
                        .description(swagger3Properties.getDescription()) // 描述Api接口文档的基本信息
                        .version(swagger3Properties.getVersion()) // 版本
                        .termsOfService(swagger3Properties.getTermsOfServiceUrl())
                        // 设置OpenAPI文档的联系信息，包括联系人姓名为"patrick"，邮箱为"patrick@gmail.com"。
                        .contact(new Contact().name(swagger3Properties.getName()).email(swagger3Properties.getEmail()))
                        // 设置OpenAPI文档的许可证信息，包括许可证名称为"Apache 2.0"，许可证URL为"http://springdoc.org"。
                        .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                );

    }

    /**
     * 订单模块的API分组
     */
//    @Bean
//    public GroupedOpenApi orderApi() { // 创建了一个api接口的分组
//        return GroupedOpenApi.builder()
//                .group("订单模块") // 分组名称
//                .pathsToMatch("/order/**") // 接口请求路径规则
//                .build();
//    }

    @Bean
    public GroupedOpenApi consumerApi() {
        return GroupedOpenApi.builder()
                .group("消费者模块") // 分组名称
                .pathsToMatch("/consumer/**") // 匹配 consumer 服务的接口
                .build();
    }

    @Bean
    public GroupedOpenApi providerConsulApi() {
        return GroupedOpenApi.builder()
                .group("消费者端获取Consul数据") // 分组名称
                .pathsToMatch("/Consul/**") // 匹配 consumer 服务的接口
                .build();
    }

    @Bean
    public GroupedOpenApi OrderApi() {
        return GroupedOpenApi.builder()
                .group("订单模块") // 分组名称
                .pathsToMatch("/Order/**") // 匹配 consumer 服务的接口
                .build();
    }



}
