package com.itneo.mapper;

import com.itneo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join location l on e.location_id = l.id")
    public long count();

    /**
     * 分页查询
     */
    @Select("select e.*, l.name locationName from emp e left join location l on e.location_id = l.id " +
            "order by e.update_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
}
