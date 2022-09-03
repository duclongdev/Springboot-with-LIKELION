package com.homework.homework_with_likelion_w2_2.payload.dto;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeDto {
    private Long employee_id;
    private String employ_name;
    private Date birth_date;
    private String gender;
    private Long department_id;
}
