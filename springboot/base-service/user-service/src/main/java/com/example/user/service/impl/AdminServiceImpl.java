package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import com.example.user.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> selectAll(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        if (admin != null) {
            if (admin.getName() != null) {
                queryWrapper.like("name", admin.getName());
            }
            if (admin.getUsername() != null) {
                queryWrapper.like("username", admin.getUsername());
            }
        }
        return adminMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = selectAll(admin);
        return PageInfo.of(list);
    }

    @Override
    public Admin login(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", admin.getUsername())
                   .eq("password", admin.getPassword());
        return adminMapper.selectOne(queryWrapper);
    }

} 