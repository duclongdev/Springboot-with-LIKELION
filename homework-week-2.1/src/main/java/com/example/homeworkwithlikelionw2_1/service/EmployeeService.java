package com.example.homeworkwithlikelionw2_1.service;

import com.example.homeworkwithlikelionw2_1.model.Employee;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<ResponseObject> insert(Employee employee, Long depId);

    ResponseEntity<ResponseObject> getAll();

    ResponseEntity<ResponseObject> updateEmp(Employee employee, Long id);
    ResponseEntity<ResponseObject> deleteEmp(Long id);
}
