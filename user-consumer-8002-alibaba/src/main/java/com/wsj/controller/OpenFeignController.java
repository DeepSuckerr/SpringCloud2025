package com.wsj.controller;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.wsj.openFeign.UserOpenFeignAPI;
import
        org.springframework.web.bind.annotation.PostMapping;
import
        org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    UserOpenFeignAPI userOpenFeignAPI;

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @PostMapping("/consumer/register")
    public Result register(@RequestBody UserDTO
                                   userDTO) {
        return userOpenFeignAPI.registerUser(userDTO);
    }

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @PostMapping("/consumer/login")
    public Result login(@RequestBody UserDTO userDTO)
    {
        return userOpenFeignAPI.login(userDTO);
    }
}
