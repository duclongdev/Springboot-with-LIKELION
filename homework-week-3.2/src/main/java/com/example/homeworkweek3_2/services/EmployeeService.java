package com.example.homeworkweek3_2.services;

import com.example.homeworkweek3_2.payload.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> getEmployeeDto(EmployeeDto employeeDto)  ;
}
