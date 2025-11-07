package com.wsj.service.impl;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;
import com.wsj.apis.pojo.User;
import com.wsj.mapper.UserMapper;
import com.wsj.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Result registerUser(UserDTO userDTO) {
        if (userDTO.getUserName().isEmpty() || userDTO.getPassword().isEmpty()) {
            return new Result(201,"请输入名或密码");
        }

        User data = userMapper.findUserByUsernameAndPassword(userDTO.getUserName(), userDTO.getPassword());
        if (data != null) {
            return new Result(204,"用户已注册");
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);

        // [!重要!] 在这里添加设置时间的代码
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        user.setCreateTime(now);
        user.setModifyTime(now);

        int row = userMapper.registerUser(user);
        if(row>0){
            return new Result(200,"注册成功");
        }
        return new Result(202,"注册失败");
    }

    @Override
    public Result login(UserDTO userDTO) {
        if (userDTO.getUserName().isEmpty() || userDTO.getPassword().isEmpty()) {
            return new Result(201, "请输入用户名或密码");
        }

        //TODO 校验验证码


        User user = userMapper.findUserByUsernameAndPassword(userDTO.getUserName(), userDTO.getPassword());

        if (user != null) {
            return new Result("登录成功", 200, user);
        }

        return new Result(203, "用户名或密码错误");
    }
}