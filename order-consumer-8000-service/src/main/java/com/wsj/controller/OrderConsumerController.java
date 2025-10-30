package com.wsj.controller;

import com.wsj.DTO.OrderDTO;
import com.wsj.commons.Result;
import com.wsj.config.RestTemplate;
import com.wsj.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
@Tag(name = "订单管理")
public class OrderConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    @Operation(summary = "新增消费者订单",description = "订单管理")
    public Result addOrder(@RequestBody OrderDTO orderDTO){

        return orderService.addOrderService(orderDTO);

    }


}
