package com.example.homeworkwithlikelionw2_1.service.impl;

import com.example.homeworkwithlikelionw2_1.model.Department;
import com.example.homeworkwithlikelionw2_1.model.Employee;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import com.example.homeworkwithlikelionw2_1.repository.DepartmentRepo;
import com.example.homeworkwithlikelionw2_1.repository.EmployeeRepo;
import com.example.homeworkwithlikelionw2_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public ResponseEntity<ResponseObject> insert(Employee employee, Long depId) {
        Optional<Department> department = departmentRepo.findById(depId);
        if (!department.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new ResponseObject("Failed", "Can't found department id", ""));
        employee.setDepartment(department.get());
        employeeRepo.save(employee);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("Ok", "Insert data successfully", "hi"));
    }

    @Override
    public ResponseEntity<ResponseObject> getAll() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("OK", "Show data successfully", employees));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("OK", "No thing to show", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> updateEmp(Employee newEmployee, Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            employee.map(tempEmployee ->{
                tempEmployee.setName(newEmployee.getName());
                tempEmployee.setDof(newEmployee.getDof());
                tempEmployee.setGender(newEmployee.isGender());
                return employeeRepo.save(tempEmployee);
            }).orElseGet(()->{
                return employeeRepo.save(newEmployee);
            });
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Employee not exits", ""));

    }

    @Override
    public ResponseEntity<ResponseObject> deleteEmp(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent())
        {
            employeeRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("OK", "delete data successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Department not exits", ""));
    }
}
