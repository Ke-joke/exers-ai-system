package com.itneo.service;

import com.itneo.pojo.Emp;
import com.itneo.pojo.EmpQueryParam;
import com.itneo.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    void save(Emp emp);

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
