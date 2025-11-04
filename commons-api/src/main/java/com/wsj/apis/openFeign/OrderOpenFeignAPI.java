package com.wsj.apis.openFeign;

import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Claude
 * @date 2025/11/04
 */
@FeignClient(value = "provider-order")
public interface OrderOpenFeignAPI {

    // =================  Order Methods =================
    @PostMapping("/order/addOrder")
    @Operation(summary = "新增订单",description = "订单管理")
    Result addOrder(@RequestBody OrderDTO orderDTO);

    @PutMapping("/order/updateOrder")
    @Operation(summary = "修改订单", description = "根据id修改订单数据")
    Result updateOrder(@RequestBody OrderDTO orderDTO);

    @DeleteMapping("/order/delete/{id}")
    @Operation(summary = "删除订单", description = "根据id删除订单")
    Result deleteOrder(@PathVariable("id") Long id);

    @GetMapping("/order/findAll")
    @Operation(summary = "查询所有订单", description = "查询所有订单")
    Result findAllOrders();

    @GetMapping("/order/findById/{id}")
    @Operation(summary = "根据id查询订单", description = "根据id查询订单")
    Result findOrderById(@PathVariable("id") Long id);

    @GetMapping("/consul/getData")
    @Operation(summary = "获取Consul配置的数据")
    Result getDataFromConsul();

    // =================  Micrometer Method (MERGED) =================
    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);
}