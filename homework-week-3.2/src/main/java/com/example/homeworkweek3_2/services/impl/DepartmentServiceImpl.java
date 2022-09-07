package com.example.homeworkweek3_2.services.impl;

import com.example.homeworkweek3_2.payload.dto.DepartmentDto;
import com.example.homeworkweek3_2.payload.responses.ResponseObject;
import com.example.homeworkweek3_2.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public ResponseEntity<?> getDepartmentDto(DepartmentDto departmentDto) {
        LOGGER.info("Department DTO: " + departmentDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "Show departmentDto successfully", departmentDto));
    }
}
