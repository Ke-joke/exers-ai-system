package com.itneo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerTypeOption {

    private List jobList;
    // private List exerTypeList; // 锻炼方式列表
    private List dataList; // 数据列表

}
