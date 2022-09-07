package com.example.homeworkweek3_2.controlers;


import com.example.homeworkweek3_2.exceptions.HandlerExceptions;
import com.example.homeworkweek3_2.exceptions.customerExceptions.InvalidArgumentException;
import com.example.homeworkweek3_2.payload.dto.EmployeeDto;
import com.example.homeworkweek3_2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("testValid")
    public ResponseEntity<?> test(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Department valid");
    }
    @PostMapping("getEmployeeDto")
    public ResponseEntity<?> getDepartmentDto(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidArgumentException(bindingResult);
        }
        return employeeService.getEmployeeDto(employeeDto);
    }
}
