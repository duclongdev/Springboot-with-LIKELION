package com.homework.homework_with_likelion_w2_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.util.Date;

@Data
public class Employee {
    private Long employee_id;
    private String employ_name;
    private Date birth_date;
    private String gender;
    @JsonIgnore
    private Department department;
}
