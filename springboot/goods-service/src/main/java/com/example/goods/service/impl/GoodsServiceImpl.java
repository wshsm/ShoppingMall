package com.example.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.goods.entity.Goods;
import com.example.goods.mapper.GoodsMapper;
import com.example.goods.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void deleteById(Integer id) {
        goodsMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        goodsMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Goods goods) {
        goodsMapper.updateById(goods);
    }

    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> selectAll(Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (goods != null) {
            if (goods.getName() != null) {
                queryWrapper.like("name", goods.getName());
            }
            if (goods.getCategoryId() != null) {
                queryWrapper.eq("category_id", goods.getCategoryId());
            }
            if (goods.getStatus() != null) {
                queryWrapper.eq("status", goods.getStatus());
            }
        }
        return goodsMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Goods> selectPage(Goods goods, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = selectAll(goods);
        return PageInfo.of(list);
    }

    @Override
    public List<Goods> selectTop5() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 5");
        return goodsMapper.selectList(queryWrapper);
    }

    @Override
    public List<Goods> selectByCategoryId(Integer categoryId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        return goodsMapper.selectList(queryWrapper);
    }
} 