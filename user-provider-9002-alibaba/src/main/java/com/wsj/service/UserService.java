package com.wsj.service;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;
import com.wsj.apis.pojo.User;

public interface UserService {

    Result registerUser(UserDTO userDTO);

    Result login(UserDTO userDTO);

}