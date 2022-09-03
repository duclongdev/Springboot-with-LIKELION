package com.example.homeworkwithlikelionw2_1.service;

import com.example.homeworkwithlikelionw2_1.model.Department;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<ResponseObject> insertData(Department department);

    ResponseEntity<ResponseObject> getAll();

    ResponseEntity<ResponseObject> getDepById(Long id);
    ResponseEntity<ResponseObject> updateDep(Long id, Department department);
    ResponseEntity<ResponseObject> deleteDep(Long id);
}
