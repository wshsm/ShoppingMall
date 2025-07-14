package com.example.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.order.entity.Cart;
import com.example.order.mapper.CartMapper;
import com.example.order.service.CartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public void add(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public void deleteById(Integer id) {
        cartMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        cartMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Cart cart) {
        cartMapper.updateById(cart);
    }

    @Override
    public Cart selectById(Integer id) {
        return cartMapper.selectById(id);
    }

    @Override
    public List<Cart> selectAll(Cart cart) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        if (cart != null) {
            if (cart.getUserId() != null) {
                queryWrapper.eq("user_id", cart.getUserId());
            }
            if (cart.getGoodsId() != null) {
                queryWrapper.eq("goods_id", cart.getGoodsId());
            }
        }
        return cartMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Cart> selectPage(Cart cart, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Cart> list = selectAll(cart);
        return PageInfo.of(list);
    }
} 