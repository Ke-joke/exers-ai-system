package com.itneo.service;

import com.itneo.pojo.ExerTypeOption;

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
}
