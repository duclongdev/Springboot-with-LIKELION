package com.example.homeworkwithlikelionw2_1.controller;

import com.example.homeworkwithlikelionw2_1.model.Employee;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import com.example.homeworkwithlikelionw2_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getAll")
    public ResponseEntity<ResponseObject> getAll()
    {
        return employeeService.getAll();
    }
    @PostMapping("/insert/{id}")
    public ResponseEntity<ResponseObject> insert(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.insert(employee, id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateData(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.updateEmp(employee, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteData(@PathVariable Long id){
        return employeeService.deleteEmp(id);
    }
}
