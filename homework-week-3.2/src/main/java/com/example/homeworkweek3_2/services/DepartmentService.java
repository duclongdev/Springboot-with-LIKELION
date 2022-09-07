package com.example.homeworkweek3_2.services;

import com.example.homeworkweek3_2.payload.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<?> getDepartmentDto(DepartmentDto departmentDto);
}
