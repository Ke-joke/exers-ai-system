package com.itneo.service.impl;

import com.itneo.mapper.EmpMapper;
import com.itneo.pojo.Emp;
import com.itneo.pojo.PageResult;
import com.itneo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. 调用mapper接口，查询总记录数
        Long total = empMapper.count();

        //2. 调用mapper接口，查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize);

        //3. 封住结果 PageResult
        return new PageResult<Emp>(total, empList);
    }
}
