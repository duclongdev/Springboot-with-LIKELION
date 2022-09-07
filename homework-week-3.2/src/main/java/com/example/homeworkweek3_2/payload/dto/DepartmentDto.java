package com.example.homeworkweek3_2.payload.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Data
public class DepartmentDto {
    Long departmentId;
    @NotBlank(message = "{validation.not_blank}")
    @Size(min = 20, message = "{validation.department.name.size.too.short}")
    @Size(max = 50, message = "{validation.department.name.size.too.long}")
    String depName;
    @NotBlank(message = "{validation.not_blank}")
    String description;
    @Valid
    List<EmployeeDto> employeeDtoList;
}
