package com.itneo.mapper;

import com.itneo.pojo.StuQueryParam;
import com.itneo.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    /**
     * 根据班级ID查询班级人数
     */
    int countStudentByClazzId(Integer id);

    /**
     * 分页查询
     */
    List<Student> list(StuQueryParam stuQueryParam);

    /**
     * 新增学员
     */
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time)" +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insert(Student student);

    /**
     * 根据ID查询学员信息
     */
    Student getInfo(Integer id);

    /**
     * 修改学员信息
     */
    void updateById(Student student);

    /**
     * 批量删除学员
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 统计学员学历人数
     */
    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();
}
