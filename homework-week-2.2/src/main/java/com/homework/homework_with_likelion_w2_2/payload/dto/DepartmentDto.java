package com.homework.homework_with_likelion_w2_2.payload.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long department_id;
    private String dept_name;
    private String description;
    private Integer count;
}
