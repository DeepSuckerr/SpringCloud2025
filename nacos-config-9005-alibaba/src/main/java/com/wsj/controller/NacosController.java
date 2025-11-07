package com.wsj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${user.info}")
    String info;

    @GetMapping("/info")
    public String getInfo() {
        return "获取的数据是：" + info;
    }

}
