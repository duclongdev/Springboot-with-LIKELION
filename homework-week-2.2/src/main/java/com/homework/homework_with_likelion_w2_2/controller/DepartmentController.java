package com.homework.homework_with_likelion_w2_2.controller;

import com.homework.homework_with_likelion_w2_2.entity.Department;
import com.homework.homework_with_likelion_w2_2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> insertDepartment(@RequestBody Department department){
        return departmentService.createData(department);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @GetMapping("/countEmployee/{id}")
    public ResponseEntity<?> countEmployeeByDepartmentId(@PathVariable Long id){
        return departmentService.findByIdIncludeEmployeeQuantity(id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        return departmentService.deleteById(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Department department)
    {
        return departmentService.updateById(id, department);
    }
}
