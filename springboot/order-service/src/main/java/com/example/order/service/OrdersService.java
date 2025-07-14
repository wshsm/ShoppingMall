package com.example.order.service;

import com.example.order.entity.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrdersService {
    void add(Orders orders);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Orders orders);
    Orders selectById(Integer id);
    List<Orders> selectAll(Orders orders);
    PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize);
} 