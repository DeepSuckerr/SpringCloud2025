package com.wsj.controller;

import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
@Tag(name = "订单管理")
public class OrderConsumerController {

    @Autowired
    RestTemplate restTemplate;

    String providerUrl = "http://provider-order";


    @PostMapping("/add")
    @Operation(summary = "新增消费者订单",description = "订单管理")
    public Result addOrder(@RequestBody OrderDTO orderDTO){

        Result result = restTemplate.postForObject(providerUrl + "/Order/addOrder", orderDTO,Result.class);
        System.out.println("result="+result);
        return result;

    }

    @PutMapping("/update")
    @Operation(summary = "修改消费者订单")
    public Result updateOrder(@RequestBody OrderDTO orderDTO) {
        restTemplate.put(providerUrl + "/Order/updateOrder", orderDTO);
        // Put method does not return a body, so we create a success result manually
        return new Result("更新成功", 200, null);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除消费者订单")
    public Result deleteOrder(@PathVariable Long id) {
        restTemplate.delete(providerUrl + "/Order/delete/" + id);
        // Delete method does not return a body, so we create a success result manually
        return new Result("删除成功", 200, null);
    }

    @GetMapping("/findAll")
    @Operation(summary = "查询所有消费者订单")
    public Result findAllOrders() {
        return restTemplate.getForObject(providerUrl + "/Order/findAll", Result.class);
    }

    @GetMapping("/findById/{id}")
    @Operation(summary = "根据id查询消费者订单")
    public Result findOrderById(@PathVariable Long id) {
        return restTemplate.getForObject(providerUrl + "/Order/findById/" + id, Result.class);
    }
}
