package com.homework.homework_with_likelion_w2_2.service;


import com.homework.homework_with_likelion_w2_2.payload.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> createData(EmployeeDto employeeDto);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> getEmployeeDetail(Long id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> updateById(Long id, EmployeeDto employeeDto);

}
