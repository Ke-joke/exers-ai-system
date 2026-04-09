package com.itneo.service;

import com.itneo.pojo.Emp;
import com.itneo.pojo.EmpQueryParam;
import com.itneo.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

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
     * 批量删除员工 - 列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 修改员工信息
     */
    void update(Emp emp);

    /**
     * 查询所有员工
     */
    List<Emp> findAll();

    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
