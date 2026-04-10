package com.itneo.service.impl;

import com.itneo.mapper.ClazzMapper;
import com.itneo.mapper.EmpMapper;
import com.itneo.mapper.StuMapper;
import com.itneo.pojo.ExerTypeOption;
import com.itneo.pojo.StuCountOption;
import com.itneo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StuMapper stuMapper;

    @Override
    public ExerTypeOption getEmpExerTypeData() {
        // 1. 调用Mapper接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpEmpTypeData(); //map: pos=有氧训练, num=14

        // 2. 组装结果，并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new ExerTypeOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public StuCountOption getStudentCountData() {
        // 1. 调用Mapper接口，获取统计数据
        List<Map<String, Object>> list = clazzMapper.countEmpEmpTypeData(); //map: clazzName=JavaWeb-ai, num=1

        // 2. 组装结果，并返回
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazzName")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new StuCountOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return stuMapper.countStudentDegreeData();
    }


}
