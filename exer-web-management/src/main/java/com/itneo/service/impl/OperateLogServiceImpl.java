package com.itneo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itneo.mapper.OperateLogMapper;
import com.itneo.pojo.OperateLog;
import com.itneo.pojo.OperateLogQueryParam;
import com.itneo.pojo.PageResult;
import com.itneo.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(OperateLogQueryParam operateLogQueryParam) {
        // 1. 设置分页参数
        PageHelper.startPage(operateLogQueryParam.getPage(), operateLogQueryParam.getPageSize());

        // 2. 执行分页查询
       List<OperateLog> logList = operateLogMapper.list(operateLogQueryParam);

        // 3. 解析查询结果，并封装
        Page<OperateLog> p = (Page<OperateLog>) logList;
        return new PageResult<OperateLog>(p.getTotal(), p.getResult());
    }
}
