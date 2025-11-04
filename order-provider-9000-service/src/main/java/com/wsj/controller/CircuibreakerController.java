package com.wsj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/consumer")
public class CircuibreakerController {

    @GetMapping("/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id){
        if( id == -4){
            throw new RuntimeException("id不能为负数");
        }
        if( id == 9999){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  "无异常,正常响应";
    }
}
