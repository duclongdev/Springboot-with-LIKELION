package com.homework.homework_with_likelion_w2_2.service;

import com.homework.homework_with_likelion_w2_2.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<?> createData(Department department);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> findByIdIncludeEmployeeQuantity(Long id);
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> updateById(Long id, Department department);
}
