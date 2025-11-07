package com.wsj.controller;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user/consumer")
public class UserConsumerController {

    @Autowired
    @Qualifier("restTemplate3")
    RestTemplate restTemplate;

    @Value("${server-url}")
    String serviceUrl;


    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        Result result = restTemplate.postForObject(serviceUrl+"/reg/userRegister", userDTO, Result.class);

        return result;
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        return restTemplate.postForObject(serviceUrl+"/reg/login", userDTO, Result.class);
    }


}