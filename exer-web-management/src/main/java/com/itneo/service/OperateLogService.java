package com.itneo.service;

import com.itneo.pojo.OperateLog;
import com.itneo.pojo.OperateLogQueryParam;
import com.itneo.pojo.PageResult;

public interface OperateLogService {

    /**
     * 日志信息的分页查询
     */
    PageResult<OperateLog> page(OperateLogQueryParam operateLogQueryParam);
}
