package com.example.user.service;

import com.example.user.entity.Account;
import com.example.user.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    void add(User user);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(User user);
    User selectById(Integer id);
    List<User> selectAll(User user);
    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);
    User login(User user);
    void register(User user);
    void updatePassword(User user);
    Account login(Account account);
    void register(Account account);
    void updatePassword(Account account);
} 