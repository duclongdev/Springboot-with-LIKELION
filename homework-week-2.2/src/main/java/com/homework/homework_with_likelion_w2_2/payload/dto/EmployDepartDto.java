package com.homework.homework_with_likelion_w2_2.payload.dto;

import com.homework.homework_with_likelion_w2_2.entity.Department;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
public class EmployDepartDto {
    private Long employee_id;
    private String employ_name;
    private Date birth_date;
    private String gender;
    private Long department_id;
    private String dept_name;
    private String description;
}
