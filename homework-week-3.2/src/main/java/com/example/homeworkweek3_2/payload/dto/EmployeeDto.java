package com.example.homeworkweek3_2.payload.dto;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class EmployeeDto {

    private Long employee_id;
    @NotBlank(message = "{validation.not_blank}")
    @Size(min = 10, message = "{validation.employee.name.size.too_short}")
    @Size(max = 50, message = "validation")
    private String employeeName;
    private Date birthDate;
    private boolean gender;
    @Email(message = "{validation.employee.email}")
    private String email;

}
