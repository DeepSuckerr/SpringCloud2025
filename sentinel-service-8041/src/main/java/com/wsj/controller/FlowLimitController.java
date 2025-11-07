package com.wsj.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return  "访问FlowLimitController的testA";
    }


    @GetMapping("/testB")
    public String testB(){
        return  "访问FlowLimitController的testB";
    }




}
