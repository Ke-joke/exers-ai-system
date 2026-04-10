package com.itneo.service;

import com.itneo.pojo.PageResult;
import com.itneo.pojo.StuQueryParam;
import com.itneo.pojo.Student;

import java.util.List;

public interface StuService {

    /**
     * 分页查询
     */
    PageResult<Student> page(StuQueryParam stuQueryParam);

    /**
     * 新增学员
     */
    void save(Student student);

    /**
     * 根据ID查询学员信息
     */
    Student getInfo(Integer id);

    /**
     * 修改学员信息
     */
    void update(Student student);

    /**
     * 批量删除学员
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 违纪处理
     */
    void violation(Integer id, Short score);
}
