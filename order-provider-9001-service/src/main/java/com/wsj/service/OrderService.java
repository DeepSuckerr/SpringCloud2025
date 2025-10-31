package com.wsj.service;

import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;

public interface OrderService {

    Result addOrderService(OrderDTO orderDTO);

    Result updateOrder(OrderDTO orderDTO);

    Result deleteOrder(Long id);

    Result findAllOrders();

    Result findOrderById(Long id);

}
