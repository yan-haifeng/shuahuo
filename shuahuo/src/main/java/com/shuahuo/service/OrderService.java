package com.shuahuo.service;

import com.shuahuo.bean.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAllOrder();

    public List<Order> findOrderById(Integer id);

    public List<Order> findOrderByUserId(Integer id);

    public List<Order> findOrderByStudioId(Integer id);

    public int addOrder(Order order);

    public int updateOrder(Order order);

    public int deleteOrder(Integer id);
}
