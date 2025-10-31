package com.wsj.service.impl;

import com.wsj.apis.DTO.OrderDTO;
import com.wsj.apis.commons.Result;
import com.wsj.mapper.OrderMapper;
import com.wsj.apis.pojo.Order;
import com.wsj.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Result addOrderService(OrderDTO orderDTO) {
        if (orderDTO.getOrderName()==null||orderDTO.getOrderName().isEmpty()){
            return new Result("订单信息不能为空",201,null);
        }

        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);

        order.setCreateTime(new java.util.Date());
        order.setModifyTime(new java.util.Date());

        int row =  orderMapper.addOrder(order);
        if (row !=1){
            return new Result("订单添加失败",202,null);
        }
        return new Result("订单添加成功",200,row);
    }

    @Override
    public Result updateOrder(OrderDTO orderDTO) {
        if(orderDTO.getOrderName()==null||orderDTO.getOrderName().isEmpty()){
            return new Result("订单信息不能为空",201,null);
        }
        if (orderDTO.getPrice()==null||orderDTO.getPrice().isEmpty()){
            return new Result("订单信息不能为空",203,null);
        }
        if (orderDTO.getOrderNum()==null){
            return new Result("订单信息不能为空",204,null);
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setModifyTime(new java.util.Date());

        int row = orderMapper.updateByPrimaryKeySelective(order);
        if (row != 1) {
            return new Result("订单更新失败", 202, null);
        }
        return new Result("订单更新成功", 200, row);
    }

    @Override
    public Result deleteOrder(Long id) {
        int row = orderMapper.deleteByPrimaryKey(id);
        if (row != 1) {
            return new Result("订单删除失败", 202, null);
        }
        return new Result("订单删除成功", 200, row);
    }

    @Override
    public Result findAllOrders() {
        java.util.List<Order> orders = orderMapper.selectAll();
        return new Result("查询成功", 200, orders);
    }

    @Override
    public Result findOrderById(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null) {
            return new Result("未找到订单", 404, null);
        }
        return new Result("查询成功", 200, order);
    }
}
