package com.example.user.service;

import com.example.user.entity.Account;
import com.example.user.entity.Business;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BusinessService {
    void add(Business business);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Business business);
    Business selectById(Integer id);
    List<Business> selectAll(Business business);
    PageInfo<Business> selectPage(Business business, Integer pageNum, Integer pageSize);
    Account login(Account account);
    void register(Account account);
    void updatePassword(Account account);
} 