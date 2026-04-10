package com.itneo.mapper;

import com.itneo.pojo.Clazz;
import com.itneo.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    /**
     * 查询所有班级信息
     */
    @Select("select id, name, room, begin_date, end_date," +
            " master_id, subject, create_time, update_time " +
            "from clazz")
    List<Clazz> findAll();

    /**
     * 新增班级信息
     */
    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    /**
     * 条件查询员工信息
     */
    List<Clazz> list(ClazzQueryParam cQueryParam);

    /**
     * 根据ID查询员工信息
     */
    Clazz getInfo(Integer id);

    /**
     * 根据ID修改员工信息
     */
    void updateById(Clazz clazz);

    /**
     * 根据ID删除员工信息
     */
    void deleteById(Integer id);

    /**
     * 统计班级学员人数
     */
    @MapKey("clazzName")
    List<Map<String, Object>> countEmpEmpTypeData();
}
