package com.wsj.controller;

import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import com.wsj.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Tag(name = "订单管理")
public class OrderController {


    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    @Operation(summary = "新增订单",description = "订单管理")
    public Result addOrder(@RequestBody OrderDTO orderDTO){

        return orderService.addOrderService(orderDTO);

    }

    @PutMapping("/updateOrder")
    @Operation(summary = "修改订单", description = "根据id修改订单数据")
    public Result updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除订单", description = "根据id删除订单")
    public Result deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }



    @GetMapping("/findAll")
    @Operation(summary = "查询所有订单", description = "查询所有订单")
    public Result findAllOrders() {
        System.out.println("执行了9001的服务");
        return orderService.findAllOrders();
    }



    @GetMapping("/findById/{id}")
    @Operation(summary = "根据id查询订单", description = "根据id查询订单")
    public Result findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }
}
