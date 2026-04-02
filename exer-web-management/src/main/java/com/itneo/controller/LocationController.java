package com.itneo.controller;

import com.itneo.pojo.Location;
import com.itneo.pojo.Result;
import com.itneo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    // @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @GetMapping("/locations")
    public Result list() {
        System.out.println("查询所有地址数据");
        List<Location> locationList = locationService.findAll();
        return Result.success(locationList);
    }

}
