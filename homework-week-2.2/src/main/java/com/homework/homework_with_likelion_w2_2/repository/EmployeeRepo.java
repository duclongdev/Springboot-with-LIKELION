package com.homework.homework_with_likelion_w2_2.repository;


import com.homework.homework_with_likelion_w2_2.entity.Employee;
import com.homework.homework_with_likelion_w2_2.payload.dto.EmployDepartDto;
import com.homework.homework_with_likelion_w2_2.payload.dto.EmployeeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeRepo {

    @Insert("INSERT INTO EMPLOYEE (employ_name, birth_date, gender, department_id) VALUES(#{employ_name}, " +
            "#{birth_date}, #{gender}, #{department_id})")
    @Options(useGeneratedKeys = true, keyProperty = "employee_id")
    int createData(EmployeeDto employeeDto);

    @Select("SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = #{id}")
    List<Employee> findByDeptId(Long id);

    @Select("SELECT * FROM EMPLOYEE em, DEPARTMENT de WHERE EMPLOYEE_ID = #{ID} " +
            "AND em.DEPARTMENT_ID = de.DEPARTMENT_ID")
    EmployDepartDto getEmployeeDetail(Long id);

    @Select("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = #{id}")
    Employee findById(Long id);
    @Select("SELECT * FROM EMPLOYEE")
    List<EmployeeDto> findALL();
    @Delete("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = #{id}")
    int deleteById(Long id);

    @Update("UPDATE EMPLOYEE SET EMPLOY_NAME = #{employ_name}, DEPARTMENT_ID = #{department_id}, " +
            "BIRTH_DATE = #{birth_date}, GENDER = #{gender} WHERE EMPLOYEE_ID = #{employee_id}")
    int updateById(EmployeeDto employeeDto);

}
