package com.itneo.service;

import com.itneo.pojo.ExerTypeOption;
import com.itneo.pojo.StuCountOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计员工锻炼方式人数
     */
    ExerTypeOption getEmpExerTypeData();

    /**
     * 统计员工性别人数
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 班级人数统计
     */
    StuCountOption getStudentCountData();

    /**
     * 学员学历统计
     */
    List<Map<String, Object>> getStudentDegreeData();
}
