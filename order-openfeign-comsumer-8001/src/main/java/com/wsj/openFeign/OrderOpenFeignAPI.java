package com.wsj.openFeign;


import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "provider-order")
public interface OrderOpenFeignAPI {

    @PostMapping("/order/addOrder")
    @Operation(summary = "新增订单",description = "订单管理")
    public Result addOrder(@RequestBody OrderDTO orderDTO);




    @PutMapping("/order/updateOrder")
    @Operation(summary = "修改订单", description = "根据id修改订单数据")
    public Result updateOrder(@RequestBody OrderDTO orderDTO);


    @DeleteMapping("/order/delete/{id}")
    @Operation(summary = "删除订单", description = "根据id删除订单")
    public Result deleteOrder(@PathVariable("id") Long id);




    @GetMapping("/order/findAll")
    @Operation(summary = "查询所有订单", description = "查询所有订单")
    public Result findAllOrders();



    @GetMapping("/order/findById/{id}")
    @Operation(summary = "根据id查询订单", description = "根据id查询订单")
    public Result findOrderById(@PathVariable("id") Long id) ;


    @GetMapping("/consul/getData")
    @Operation(summary = "获取Consul配置的数据")
    public Result getDataFromConsul();


}