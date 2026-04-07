package com.itneo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itneo.mapper.EmpExprMapper;
import com.itneo.mapper.EmpMapper;
import com.itneo.pojo.*;
import com.itneo.service.EmpLogService;
import com.itneo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    /**
     * 原始分页查询
     * @param page
     * @param pageSize
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. 调用mapper接口，查询总记录数
        Long total = empMapper.count();

        //2. 调用mapper接口，查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize);

        //3. 封住结果 PageResult
        return new PageResult<Emp>(total, empList);
    }*/

    /**
     * PageHelper分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * 注意事项：
     *        1. 定义的SQL语句不能加分号;
     *        2. PageHelper仅仅能对紧跟在其后的第一个查询进行分页处理
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> emplist =  empMapper.list(name, gender, begin, end);

        //3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) emplist;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }*/

    @Override
    public PageResult<Emp> page(EmpQueryParam  empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<Emp> emplist =  empMapper.list(empQueryParam);

        //3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) emplist;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})// 事务管理 - 默认只回滚RuntimeException异常
    @Override
    public void save(Emp emp) {
        try {
            //1. 保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            //2. 保存员工工作经历信息
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)) {
                //遍历集合，为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(empId);
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工:"+emp);
            empLogService.insertLog(empLog);
        }
    }
}
