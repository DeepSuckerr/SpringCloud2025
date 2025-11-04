package com.wsj.controller;
import com.wsj.apis.openFeign.CircuibreakerAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class CircuitControllerConsumer {

    @Autowired
    CircuibreakerAPI circuibreakerAPI;


    @GetMapping("/consumer/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod="myFallBack")
    public  String myPayCircuit(@PathVariable("id") Integer id){
        return  circuibreakerAPI.myCircuit(id);
    }
    // 熔断响应数据
    public String myFallBack(@PathVariable("id") Integer id,Throwable t){
        return "服务器正忙,稍后重试!"+new Date().getTime();
    }
}