package com.itneo.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    private Integer id; //ID,主键
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Integer gender; //性别, 1:男, 2:女
    private String phone; //手机号
    //private Integer exerType;
    private Integer job; //锻炼方式, 1 核心训练, 2 有氧训练 , 3 燃脂训练, 4 普拉提锻炼, 5 拉伸放松
    //private Integer burnCalorie;
    private Integer salary; //消耗卡路里
    private String image; //头像
    private LocalDate entryDate; //锻炼日期
    //private Integer locationId;
    private Integer deptId; //关联的地址ID
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    //封装地址名称数
    //private String locationName;
    private String deptName; //地址名称
    // 封装锻炼记录信息
    //private List<EmpExpr> exprList;
    //封装工作经历信息
    private List<EmpExpr> exprList;
}
