package com.itneo.mapper;

import com.itneo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工锻炼经历
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量保存员工的锻炼经历信息
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);
}
