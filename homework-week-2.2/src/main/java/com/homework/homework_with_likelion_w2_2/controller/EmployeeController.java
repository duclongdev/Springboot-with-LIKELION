package com.homework.homework_with_likelion_w2_2.controller;

import com.homework.homework_with_likelion_w2_2.payload.dto.EmployeeDto;
import com.homework.homework_with_likelion_w2_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> insertEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createData(employeeDto);
    }
    @GetMapping("employeeDetail/{id}")
    public ResponseEntity<?> getEmployeeDetail(@PathVariable Long id){
        return employeeService.getEmployeeDetail(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        return employeeService.findAll();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateById(id, employeeDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {return employeeService.deleteById(id);}

}
