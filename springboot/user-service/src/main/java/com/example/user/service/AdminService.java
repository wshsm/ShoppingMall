package com.example.user.service;

import com.example.user.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    void add(Admin admin);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Admin admin);
    Admin selectById(Integer id);
    List<Admin> selectAll(Admin admin);
    PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize);
    Admin login(Admin admin);
    void register(Admin admin);
    void updatePassword(Admin admin);
} 