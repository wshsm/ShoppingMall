package com.example.order.service;

import com.example.order.entity.Cart;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CartService {
    void add(Cart cart);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Cart cart);
    Cart selectById(Integer id);
    List<Cart> selectAll(Cart cart);
    PageInfo<Cart> selectPage(Cart cart, Integer pageNum, Integer pageSize);
} 