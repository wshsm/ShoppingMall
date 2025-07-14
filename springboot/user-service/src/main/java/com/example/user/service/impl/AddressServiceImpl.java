package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.user.entity.Address;
import com.example.user.mapper.AddressMapper;
import com.example.user.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void add(Address address) {
        addressMapper.insert(address);
    }

    @Override
    public void deleteById(Integer id) {
        addressMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        addressMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Address address) {
        addressMapper.updateById(address);
    }

    @Override
    public Address selectById(Integer id) {
        return addressMapper.selectById(id);
    }

    @Override
    public List<Address> selectAll(Address address) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        if (address != null) {
            if (address.getUserId() != null) {
                queryWrapper.eq("user_id", address.getUserId());
            }
            if (address.getName() != null) {
                queryWrapper.like("name", address.getName());
            }
        }
        return addressMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Address> selectPage(Address address, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Address> list = selectAll(address);
        return PageInfo.of(list);
    }
} 