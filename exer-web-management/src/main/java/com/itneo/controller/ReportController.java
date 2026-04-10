package com.itneo.controller;

import com.itneo.pojo.ExerTypeOption;
import com.itneo.pojo.Result;
import com.itneo.pojo.StuCountOption;
import com.itneo.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计锻炼方式人数
     */
    @GetMapping("/empJobData")
    public Result getEmpExerTypeData() {
        log.info("统计锻炼方式人数");
        ExerTypeOption exerTypeOption = reportService.getEmpExerTypeData();
        return Result.success(exerTypeOption);
    }

    /**
     * 统计员工性别人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别人数");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("班级人数统计");
        StuCountOption stuCountOption = reportService.getStudentCountData();
        return Result.success(stuCountOption);
    }

    /**
     * 学员学历统计
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("学员学历统计");
        List<Map<String, Object>> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }

}
