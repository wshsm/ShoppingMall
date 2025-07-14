package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.user.entity.Account;
import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (user != null) {
            if (user.getName() != null) {
                queryWrapper.like("name", user.getName());
            }
            if (user.getUsername() != null) {
                queryWrapper.like("username", user.getUsername());
            }
        }
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = selectAll(user);
        return PageInfo.of(list);
    }

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername())
                   .eq("password", user.getPassword());
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updatePassword(User user) {
        userMapper.updateById(user);
    }
} 