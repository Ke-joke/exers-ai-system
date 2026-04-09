package com.itneo.controller;

import com.itneo.pojo.*;
import com.itneo.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 查询所有班级信息
     */
    /*@GetMapping
    public Result list() {
        log.info("查询所有班级数据");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }*/

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam cQueryParam) {
        log.info("分页查询：{}",cQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(cQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加班级信息
     */
    @PostMapping("/clazzs")
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加班级数据: {}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

}
