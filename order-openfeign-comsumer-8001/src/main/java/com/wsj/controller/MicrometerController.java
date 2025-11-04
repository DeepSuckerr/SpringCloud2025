package com.wsj.controller;

import com.wsj.apis.openFeign.OrderOpenFeignAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicrometerController {

    // V V V V V V V V V V V V V V V V V V V V V V V
    // 2. 将注入的类型从 MicrometerZipkinAPI 修改为 OrderOpenFeignAPI
    @Autowired
    private OrderOpenFeignAPI orderOpenFeignAPI;
    // ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^

    @GetMapping(value = "/consumer/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        // 3. 通过合并后的接口调用方法
        return orderOpenFeignAPI.myMicrometer(id);
    }
}
