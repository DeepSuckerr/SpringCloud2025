package com.wsj.openFeign;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "nacos-user-provider")
public interface UserOpenFeignAPI {
    @PostMapping("/user/userRegister")
    public Result registerUser(@RequestBody UserDTO userDTO);

    @PostMapping("/user/login")
    public Result login(@RequestBody UserDTO userDTO);
}
