package com.itneo.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private Integer page = 1; // 页码
    private Integer pageSize = 10;// 每页记录数
    private String name; // 班级名称
    @DateTimeFormat(pattern = "yyyy/M/d")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy/M/d")
    private LocalDate end;
}
