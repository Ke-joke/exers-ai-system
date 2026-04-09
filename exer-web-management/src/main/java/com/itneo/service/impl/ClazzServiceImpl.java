package com.itneo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itneo.mapper.ClazzMapper;
import com.itneo.pojo.Clazz;
import com.itneo.pojo.ClazzQueryParam;
import com.itneo.pojo.PageResult;
import com.itneo.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /*@Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }*/

    @Override
    public void add(Clazz clazz) {
        // 1.补全基础属性 - createTime, updateTime
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        // 2.调用Mapper接口方法插入数据
        clazzMapper.insert(clazz);
    }

    @Override
    public PageResult<Clazz> page(ClazzQueryParam cQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(cQueryParam.getPage(), cQueryParam.getPageSize());

        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(cQueryParam);

        //3.解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }
}
