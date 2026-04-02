package com.itneo.mapper;

import com.itneo.pojo.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {

    /**
     * 查询所有地址信息
     */
    // 方式一：手动结果映射
    /*@Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })*/

    // 方式二：启别名
    // @Select("SELECT id, name, create_time createTime, update_time updateTime FROM location order by update_time desc;")
    @Select("SELECT id, name, create_time, update_time FROM location order by update_time desc;")
    List<Location> findAll();
}
