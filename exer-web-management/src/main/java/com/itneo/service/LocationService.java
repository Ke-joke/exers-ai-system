package com.itneo.service;

import com.itneo.pojo.Location;

import java.util.List;

public interface LocationService {

    /**
     * 查询所有地址
     * @return
     */
    List<Location> findAll();
}
