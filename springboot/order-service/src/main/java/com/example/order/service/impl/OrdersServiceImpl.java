package com.example.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.order.entity.Orders;
import com.example.order.mapper.OrdersMapper;
import com.example.order.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public void add(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        ordersMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Orders orders) {
        ordersMapper.updateById(orders);
    }

    @Override
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    @Override
    public List<Orders> selectAll(Orders orders) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        if (orders != null) {
            if (orders.getUserId() != null) {
                queryWrapper.eq("user_id", orders.getUserId());
            }
            if (orders.getOrderNo() != null) {
                queryWrapper.like("order_no", orders.getOrderNo());
            }
            if (orders.getStatus() != null) {
                queryWrapper.eq("status", orders.getStatus());
            }
        }
        return ordersMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = selectAll(orders);
        return PageInfo.of(list);
    }
} 