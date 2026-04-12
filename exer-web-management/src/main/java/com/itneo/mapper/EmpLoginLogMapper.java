package com.itneo.mapper;

import com.itneo.pojo.EmpLoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLoginLogMapper {

    @Insert("insert into emp_login_log(username,password,cost_time,login_time,jwt,is_success) " +
            "values(#{username},#{password},#{costTime},#{loginTime},#{jwt},#{isSuccess})")
    void insertLoginLog(EmpLoginLog empLoginLog);

}
