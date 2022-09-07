package com.example.homeworkweek3_2.services.impl;

import com.example.homeworkweek3_2.payload.dto.EmployeeDto;
import com.example.homeworkweek3_2.payload.responses.ResponseObject;
import com.example.homeworkweek3_2.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public ResponseEntity<?> getEmployeeDto(EmployeeDto employeeDto) {
        LOGGER.info("Employee DTO: " + employeeDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "Show employeeDto successfully", employeeDto));
    }
}
