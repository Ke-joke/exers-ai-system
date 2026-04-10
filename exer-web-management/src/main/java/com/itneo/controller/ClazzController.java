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
    @GetMapping("list")
    public Result list() {
        log.info("查询所有班级数据");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

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
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加班级数据: {}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级信息：{}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 删除班级信息
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级信息：{}", id);
        clazzService.delete(id);
        return Result.success();
    }

}
