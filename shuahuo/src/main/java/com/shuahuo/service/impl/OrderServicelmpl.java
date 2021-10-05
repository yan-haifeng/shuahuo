package com.shuahuo.service.impl;

import com.shuahuo.bean.Order;
import com.shuahuo.dao.OrderMapper;
import com.shuahuo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicelmpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> findOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }

    @Override
    public List<Order> findOrderByUserId(Integer id) {
        return orderMapper.selectOrderByUserId(id);
    }

    @Override
    public List<Order> findOrderByStudioId(Integer id) {
        return orderMapper.selectOrderByStudioId(id);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.insertOrderSelective(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrderByPrimaryKeySelective(order);
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderMapper.deleteOrderByPrimaryKey(id);
    }
}
