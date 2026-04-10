package com.itneo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itneo.mapper.StuMapper;
import com.itneo.pojo.Emp;
import com.itneo.pojo.PageResult;
import com.itneo.pojo.StuQueryParam;
import com.itneo.pojo.Student;
import com.itneo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public PageResult<Student> page(StuQueryParam stuQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(stuQueryParam.getPage(), stuQueryParam.getPageSize());

        //2. 执行查询
        List<Student> stulist =  stuMapper.list(stuQueryParam);

        //3. 解析查询结果，并封装
        Page<Student> p = (Page<Student>) stulist;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Student student) {
        // 保存学员员基本信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.insert(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return stuMapper.getInfo(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.updateById(student);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        // 批量删除员工基本信息
        stuMapper.deleteByIds(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void violation(Integer id, Short score) {
        // 查看学员是否存在
        Student student = stuMapper.getInfo(id);
        if (student == null) {
            throw new RuntimeException("学员不存在");
        }
        // 查看扣分的分数是否合法
        if (score <= 0) {
            throw new RuntimeException("扣分分数不能为负数");
        }
        // 扣分
        student.setViolationCount((short) (student.getViolationCount() + 1));
        student.setViolationScore((short) (student.getViolationScore() + score));
        stuMapper.updateById(student);
    }

}
