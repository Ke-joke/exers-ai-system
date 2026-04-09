package com.itneo.service;

import com.itneo.pojo.Clazz;
import com.itneo.pojo.ClazzQueryParam;
import com.itneo.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    /**
     * 查询所有班级信息
     */
    //List<Clazz> findAll();

    /**
     * 新增班级信息
     */
    void add(Clazz clazz);

    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam cQueryParam);
}
