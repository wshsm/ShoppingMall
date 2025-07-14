package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.user.entity.Notice;
import com.example.user.mapper.NoticeMapper;
import com.example.user.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public void add(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void deleteById(Integer id) {
        noticeMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        noticeMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateById(Notice notice) {
        noticeMapper.updateById(notice);
    }

    @Override
    public Notice selectById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public List<Notice> selectAll(Notice notice) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        if (notice != null) {
            if (notice.getTitle() != null) {
                queryWrapper.like("title", notice.getTitle());
            }
        }
        return noticeMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<Notice> selectPage(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> list = selectAll(notice);
        return PageInfo.of(list);
    }
} 