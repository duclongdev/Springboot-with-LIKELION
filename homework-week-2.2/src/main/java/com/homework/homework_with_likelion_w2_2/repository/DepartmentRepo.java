package com.homework.homework_with_likelion_w2_2.repository;

import com.homework.homework_with_likelion_w2_2.entity.Department;
import com.homework.homework_with_likelion_w2_2.payload.dto.DepartmentDto;
import org.apache.ibatis.annotations.*;


@Mapper
public interface DepartmentRepo {
    @Insert("INSERT INTO DEPARTMENT (dept_name, description) VALUES(#{dept_name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "department_id")
    int createData(Department department);
    @Select("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = #{id}")
    Department findById(Long id);
    @Select("SELECT DE.DEPARTMENT_ID, DEPT_NAME, DESCRIPTION, COUNT(EM.EMPLOYEE_ID) as COUNT FROM DEPARTMENT DE " +
            "JOIN EMPLOYEE EM ON DE.DEPARTMENT_ID = EM.DEPARTMENT_ID WHERE DE.DEPARTMENT_ID = #{id}")
    DepartmentDto countEmployForEachDep(Long id);
    @Select("SELECT COUNT(EM.DEPARTMENT_ID) FROM EMPLOYEE EM, DEPARTMENT DE WHERE DE.DEPARTMENT_ID = EM.DEPARTMENT_ID" +
            " AND DE.DEPARTMENT_ID = #{id}")
    int countEmployeeByDeptId(Long id);
    @Delete("DELETE FROM DEPARTMENT WHERE DEPARTMENT_ID = #{ID}")
    int deleteById(Long id);

    @Update("UPDATE DEPARTMENT SET DEPT_NAME = #{dept_name}, " +
            "DESCRIPTION = #{description} WHERE DEPARTMENT_ID = #{department_id}")
    int updateByID(Department department);
}
