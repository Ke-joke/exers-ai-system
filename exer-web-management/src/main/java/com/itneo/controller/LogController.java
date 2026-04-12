package com.itneo.controller;

import com.itneo.pojo.OperateLog;
import com.itneo.pojo.OperateLogQueryParam;
import com.itneo.pojo.PageResult;
import com.itneo.pojo.Result;
import com.itneo.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private OperateLogService operateLogService;

    /**
     * 日志信息的分页查询
     */
    @GetMapping("/page")
    public Result page(OperateLogQueryParam operateLogQueryParam) {
        log.info("日志信息的分页查询：{}", operateLogQueryParam);
        PageResult<OperateLog> pageResult = operateLogService.page(operateLogQueryParam);
        return Result.success(pageResult);
    }

}
