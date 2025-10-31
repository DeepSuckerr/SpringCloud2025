package com.wsj.controller;

import com.wsj.apis.commons.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul")
@Tag(name = "Consul模块服务提供者接口")
public class DataController {

    @Value("${user.username}")
    String username;

    @GetMapping("/getData")
    @Operation(summary = "获取Consul配置的数据")
    public Result getDataFromConsul() {
        if (username == null) {
            return new Result(500, "获取数据失败");
        }
        return new Result("获取数据成功", 200, username);
    }

}
