package com.wsj.mapper;


import com.wsj.apis.pojo.Order;

import java.util.List;

public interface OrderMapper {

    int addOrder(Order order);

    int updateByPrimaryKeySelective(Order order);

    int deleteByPrimaryKey(Long id);

    List<Order> selectAll();

    Order selectByPrimaryKey(Long id);


}
