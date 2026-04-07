package com.itneo.mapper;

import com.itneo.pojo.Emp;
import com.itneo.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    // ----------------------------原始分页查询实现---------------------------------
    /**
     * 查询总记录数
     */
    //@Select("select count(*) from emp e left join location l on e.location_id = l.id")
    //public long count();

    /**
     * 分页查询
     */
    //@Select("select e.*, l.name locationName from emp e left join location l on e.location_id = l.id " +
    //        "order by e.update_time desc limit #{start}, #{pageSize}")
    //public List<Emp> list(Integer start, Integer pageSize);

    /*@Select("select e.id, e.username, e.password, e.name, e.gender, e.phone, e.exer_type job, e.burn_calorie salary, " +
            "e.image, e.entry_date, e.location_id deptId, e.create_time, e.update_time, l.name deptName " +
            "from emp e left join location l on e.location_id = l.id order by e.update_time desc")*/
    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, exer_type, burn_calorie, image, entry_date, location_id, create_time, update_time)" +
            "VALUES (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);
}
