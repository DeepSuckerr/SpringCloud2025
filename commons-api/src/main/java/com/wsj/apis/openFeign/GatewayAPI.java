package com.wsj.apis.openFeign;

import com.wsj.apis.commons.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cloud-gateway")
public interface GatewayAPI {

    @GetMapping("/provider/get/{id}")
    public Result data1(@PathVariable("id") Integer id);

    @GetMapping("/provider/info")
    public String data2();

}
