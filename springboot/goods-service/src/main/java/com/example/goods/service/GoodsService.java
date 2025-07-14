package com.example.goods.service;

import com.example.goods.entity.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {
    void add(Goods goods);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Goods goods);
    Goods selectById(Integer id);
    List<Goods> selectAll(Goods goods);
    PageInfo<Goods> selectPage(Goods goods, Integer pageNum, Integer pageSize);
    // 新增
    List<Goods> selectTop5();
    List<Goods> selectByCategoryId(Integer categoryId);
} 