package com.wsj.controller;

import cn.hutool.core.util.IdUtil;
import com.wsj.apis.commons.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayDataConsumerController {

        @GetMapping("/consumer/get/{id}")

    public Result data1(@PathVariable("id") Integer id){

        if(id < 0){
            return new Result(201,"id不能为复数");
        }
        return new Result(200,"id为整数="+id);
    }

    @GetMapping("/consumer/info")
    public String data2(){
        return "提供者8001服务返回数据"+ IdUtil.simpleUUID();

    }

}