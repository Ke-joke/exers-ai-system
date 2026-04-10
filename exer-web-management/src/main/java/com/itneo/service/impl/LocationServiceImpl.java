package com.itneo.service.impl;

import com.itneo.exception.HaveEmpInLocationException;
import com.itneo.mapper.LocationMapper;
import com.itneo.pojo.Location;
import com.itneo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> findAll() {
        return locationMapper.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        // 1.如果删除的班级下有员工，则不能删除
        if (locationMapper.countEmpByLocationId(id) > 0) {
            throw new HaveEmpInLocationException("对不起，当前部门下有员工，不能直接删除！");
        }
        // 2.删除班级信息
        locationMapper.deleteById(id);
    }

    @Override
    public void add(Location location) {
        // 1.补全基础属性 - createTime, updateTime
        location.setCreateTime(LocalDateTime.now());
        location.setUpdateTime(LocalDateTime.now());

        // 2.调用Mapper接口方法插入数据
        locationMapper.insert(location);
    }

    @Override
    public Location getById(Integer id) {
        return locationMapper.getById(id);
    }

    @Override
    public void update(Location location) {
        //1.补全基础属性 - updateTime
        location.setUpdateTime(LocalDateTime.now());

        //2.调用Mapper接口方法更新地址
        locationMapper.update(location);
    }
}
