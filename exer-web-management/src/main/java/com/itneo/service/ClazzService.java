package com.itneo.service;

import com.itneo.pojo.Clazz;
import com.itneo.pojo.ClazzQueryParam;
import com.itneo.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    /**
     * 查询所有班级信息
     */
    List<Clazz> findAll();

    /**
     * 新增班级信息
     */
    void add(Clazz clazz);

    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam cQueryParam);

    /**
     * 获取班级信息
     */
    Clazz getInfo(Integer id);

    /**
     * 修改班级信息
     */
    void update(Clazz clazz);

    /**
     * 删除班级信息
     */
    void delete(Integer id);
}
