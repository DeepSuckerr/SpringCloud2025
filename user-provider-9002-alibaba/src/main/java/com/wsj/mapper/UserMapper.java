package com.wsj.mapper;

import com.wsj.apis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {

    //注册功能
    int registerUser(User user);

    User findUserByUsernameAndPassword(@Param("userName") String username,
                                       @Param("password") String password );


    User login(@Param("userName") String username,
          @Param("password") String password );


}
