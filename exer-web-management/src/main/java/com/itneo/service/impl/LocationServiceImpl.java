package com.itneo.service.impl;

import com.itneo.mapper.LocationMapper;
import com.itneo.pojo.Location;
import com.itneo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> findAll() {
        return locationMapper.findAll();
    }
}
