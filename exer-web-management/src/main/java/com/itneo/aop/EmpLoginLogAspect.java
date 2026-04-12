package com.itneo.aop;


import com.itneo.mapper.EmpLoginLogMapper;
import com.itneo.pojo.Emp;
import com.itneo.pojo.EmpLoginLog;
import com.itneo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 员工登录日志切面
 */
@Slf4j
@Aspect
@Component
public class EmpLoginLogAspect {

    @Autowired
    private EmpLoginLogMapper empLoginLogMapper;

    @Around("execution(* com.itneo.controller.LoginController.login(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        long costTime = end - start;
        EmpLoginLog empLoginLog = new EmpLoginLog();
        Object[] args = joinPoint.getArgs();

        log.info("员工登录参数：{}", Arrays.toString(args));
        // [Emp(id=null, username=wusong, password=123456, name=null, gender=null,
        // phone=null, job=null, salary=null, image=null, entryDate=null, deptId=null,
        // createTime=null, updateTime=null, deptName=null, exprList=null)]
        // 如何从以上Emp中获取username和password,传递进来的是一个数组长度为1
        // 使用instanceof来判断arg[0]中是否有Emp类型的对象，如果有，进行转换
        if(args[0] instanceof Emp){
            Emp emp = (Emp) args[0];
            empLoginLog.setUsername(emp.getUsername());
            empLoginLog.setPassword(emp.getPassword());
        }
        empLoginLog.setCostTime(costTime);
        empLoginLog.setLoginTime(LocalDateTime.now());

        // 判断登录是否成功,把result转换成一个Result类型的对象，然后进行操作
        if(result instanceof Result){
            Result res = (Result)result;
            if (res.getCode()==1){
                empLoginLog.setIsSuccess((short) 1);
                if (res.getData()!=null){
                    String data = res.getData().toString();
                    int startIndex =-1;
                    for (int i = 0; i <data.length() ; i++) {
                        if(data.charAt(i) == 't'&&data.charAt(i+1)=='o'&&data.charAt(i+2)=='k'&&
                                data.charAt(i+3)=='e'&&data.charAt(i+4)=='n'&&data.charAt(i+5)=='=')
                            startIndex = i+6;//找到token的起始位置
                    }
                    log.info("startIndex:{},总长：{}",startIndex,data.length()-1);
                    empLoginLog.setJwt(data.substring(startIndex,data.length()-1 ));
                    log.info("jwt：{}",empLoginLog.getJwt());
                }
            }else {
                empLoginLog.setIsSuccess((short) 0);
            }
        }
        log.info("登录信息：{}", empLoginLog);
        empLoginLogMapper.insertLoginLog(empLoginLog);
        return  result;
    }

}
