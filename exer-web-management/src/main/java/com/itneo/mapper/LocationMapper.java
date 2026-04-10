package com.itneo.mapper;

import com.itneo.pojo.Location;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据id删除地址
     */
    @Delete("delete from location where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增地址
     */
    @Insert("insert into location(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Location location);

    /**
     * 根据id查询地址
     */
    @Select("select id, name, create_time, update_time from location where id = #{id}")
    Location getById(Integer id);

    /**
     * 修改地址
     */
    @Update("update location set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Location location);

    /**
     * 根据地址id查询员工数量
     */
    @Select("select count(1) from emp where location_id = #{id}")
    int countEmpByLocationId(Integer id);
}
