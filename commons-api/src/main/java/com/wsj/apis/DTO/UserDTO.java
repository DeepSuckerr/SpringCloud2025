package com.wsj.apis.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String tel;
    private String image;
    private Date createTime;
    private Date modifyTime;
    private String code;
    private String token;



}
