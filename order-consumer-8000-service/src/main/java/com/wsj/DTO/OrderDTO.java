package com.wsj.DTO;

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
public class OrderDTO implements Serializable {
    private Integer id;
    private String orderName;
    private String price;
    private Integer orderNumber;
    private Date createTime;
    private Date modifyTime;
    private Integer userId;


}