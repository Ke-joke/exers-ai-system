package com.itneo.service;

import com.itneo.pojo.Location;

import java.util.List;

public interface LocationService {

    /**
     * 查询所有地址
     */
    List<Location> findAll();

    /**
     * 根据ID删除地址
     */
    void deleteById(Integer id);

    /**
     * 新增地址
     */
    void add(Location location);

    /**
     * 根据ID查询地址
     */
    Location getById(Integer id);

    /**
     * 修改地址
     */
     void update(Location location);
}
