package com.example.user.service;

import com.example.user.entity.Address;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AddressService {
    void add(Address address);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Address address);
    Address selectById(Integer id);
    List<Address> selectAll(Address address);
    PageInfo<Address> selectPage(Address address, Integer pageNum, Integer pageSize);
} 