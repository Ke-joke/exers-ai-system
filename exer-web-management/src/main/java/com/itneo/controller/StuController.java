package com.itneo.controller;

import com.itneo.pojo.PageResult;
import com.itneo.pojo.Result;
import com.itneo.pojo.StuQueryParam;
import com.itneo.pojo.Student;
import com.itneo.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(StuQueryParam stuQueryParam) {
        log.info("分页查询：{}", stuQueryParam);
        PageResult<Student> pageResult = stuService.page(stuQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增学员
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学员：{}", student);
        stuService.save(student);
        return Result.success();
    }

    /**
     * 根据ID查询学员信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询学员信息，id：{}", id);
        Student student = stuService.getInfo(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息：{}", student);
        stuService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学员
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学员，ids：{}", ids);
        stuService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Short score){
        log.info("违纪处理，id：{}，score：{}", id, score);
        stuService.violation(id, score);
        return Result.success();
    }

}
