package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.user.entity.Account;
import com.example.user.entity.Business;
import com.example.user.mapper.BusinessMapper;
import com.example.user.service.BusinessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public void add(Business business) {
        businessMapper.insert(business);
    }

    @Override
    public void deleteById(Integer id) {
        businessMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        businessMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Business business) {
        businessMapper.updateById(business);
    }

    @Override
    public Business selectById(Integer id) {
        return businessMapper.selectById(id);
    }

    @Override
    public List<Business> selectAll(Business business) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        if (business != null) {
            if (business.getName() != null) {
                queryWrapper.like("name", business.getName());
            }
            if (business.getUsername() != null) {
                queryWrapper.like("username", business.getUsername());
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

    @Override
    public Account login(Account account) {
        return businessMapper.login(account);
    }

    @Override
    public void register(Account account) {
        businessMapper.insert(account);
    }

    @Override
    public void updatePassword(Account account) {
        businessMapper.updatePassword(account);
    }
} 