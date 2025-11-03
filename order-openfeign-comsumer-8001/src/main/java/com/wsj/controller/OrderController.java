package com.wsj.controller;


import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import com.wsj.openFeign.OrderOpenFeignAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="openFeign消费这模块")
@RequestMapping("/openFeign")
public class OrderController {

    @Autowired
    OrderOpenFeignAPI orderOpenFeignAPI;

    @GetMapping("/findAllOrders")
    @Operation(summary = "测试查询订单")
    public Result findAllOrders() {
        Result result = orderOpenFeignAPI.findAllOrders();
        return  result;

    }

    @PostMapping("/add")
    @Operation(summary = "添加操作")
    public Result addOrder(@RequestBody OrderDTO orderDTO) {
        Result result = orderOpenFeignAPI.addOrder(orderDTO);
        return  result;
    }

    @PutMapping("/update")
    @Operation(summary = "修改操作")
    public Result updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderOpenFeignAPI.updateOrder(orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除操作")
    public Result deleteOrder(@PathVariable("id") Long id) {
        return orderOpenFeignAPI.deleteOrder(id);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "根据id查询")
    public Result findOrderById(@PathVariable("id") Long id) {
        return orderOpenFeignAPI.findOrderById(id);
    }

    @GetMapping("/consul/get")
    @Operation(summary = "获取consul数据")
    public Result getDataFromConsul() {
        return orderOpenFeignAPI.getDataFromConsul();
    }
}