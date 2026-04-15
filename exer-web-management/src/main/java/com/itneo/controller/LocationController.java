package com.itneo.controller;

import com.itneo.anno.Log;
import com.itneo.pojo.Location;
import com.itneo.pojo.Result;
import com.itneo.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/locations")
@RestController
public class LocationController {

    // private static final Logger log = LoggerFactory.getLogger(LocationController.class);// 固定

    @Autowired
    private LocationService locationService;

    /**
     * 查询地址
     */
    // @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        // System.out.println("查询所有地址数据");
        log.info("查询所有地址数据");
        List<Location> locationList = locationService.findAll();
        return Result.success(locationList);
    }

    /**
     * 删除地址 方式一：HttpServletRequest 获取请求参数
     */
    /*@DeleteMapping("/depts")
    public Result delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        System.out.println("根据ID删除地址：" + id);
        return Result.success();
    }*/

    /**
     * 删除地址 方式二：@RequestParam
     * 注意事项：一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错，（默认 required = true）
     */
    /*@DeleteMapping("/depts")
    public Result delete(@RequestParam(value = "id",required = false) Integer locationId) {
        System.out.println("根据ID删除地址：" + locationId);
        return Result.success();
    }*/

    /**
     * 删除地址 方式三：省略@RequestParam（前端传递的请求参数名与服务端方法参数名一致）
     */
    @Log
    @DeleteMapping
    public Result delete(Integer id) {
        // System.out.println("根据ID删除地址：" + id);
        log.info("根据ID删除地址：{}", id);
        locationService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增地址
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Location location) {
        // System.out.println("新增地址：" + location);
        log.info("新增地址：{}", location);
        locationService.add(location);
        return Result.success();
    }

    /**
     * 根据ID查询地址
     */
    /*@GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer locationId) {
        System.out.println("根据ID查询地址：" + locationId);
        return Result.success();
    }*/

    /**
     * 根据ID查询地址
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        // System.out.println("根据ID查询地址：" + id);
        log.info("根据ID查询地址：{}", id);
        Location location = locationService.getById(id);
        return Result.success(location);
    }

    /**
     * 修改地址
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Location location) {
        // System.out.println("修改地址：" + location);
        log.info("修改地址：{}", location);
        locationService.update(location);
        return Result.success();
    }

}
