package com.example.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Business;
import com.example.mapper.BusinessMapper;
import com.example.business.service.BusinessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper,Business> implements BusinessService {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public List<Business> selectAll(Business business) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        if (business != null) {
            if (business.getName() != null) {
                queryWrapper.like("name", business.getName());
            }
            if (business.getStatus() != null) {
                queryWrapper.eq("status", business.getStatus());
            }
        }
        return businessMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Business> selectPage(Business business, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Business> list = selectAll(business);
        return PageInfo.of(list);
    }
} 