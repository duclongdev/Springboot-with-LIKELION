package com.homework.homework_with_likelion_w2_2.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
public class Department {
    private Long department_id;
    private String dept_name;
    private String description;
    @ToString.Exclude
    private List<Employee> employees;
}
