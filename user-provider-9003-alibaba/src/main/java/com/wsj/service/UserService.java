package com.wsj.service;

import com.wsj.apis.DTO.UserDTO;
import com.wsj.apis.commons.Result;

public interface UserService {

    Result registerUser(UserDTO userDTO);

    Result login(UserDTO userDTO);

}