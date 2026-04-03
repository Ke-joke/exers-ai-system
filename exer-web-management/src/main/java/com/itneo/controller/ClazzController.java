package com.itneo.controller;

import com.itneo.pojo.Clazz;
import com.itneo.pojo.Result;
import com.itneo.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 查询所有班级信息
     */
    @GetMapping("/clazzs")
    public Result list() {
        log.info("查询所有班级数据");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
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
