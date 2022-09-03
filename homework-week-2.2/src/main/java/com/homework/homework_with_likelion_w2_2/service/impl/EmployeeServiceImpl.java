package com.homework.homework_with_likelion_w2_2.service.impl;

import com.homework.homework_with_likelion_w2_2.entity.Employee;
import com.homework.homework_with_likelion_w2_2.payload.dto.EmployDepartDto;
import com.homework.homework_with_likelion_w2_2.payload.dto.EmployeeDto;
import com.homework.homework_with_likelion_w2_2.repository.EmployeeRepo;
import com.homework.homework_with_likelion_w2_2.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ResponseEntity<?> createData(EmployeeDto employeeDto) {
        if(employeeRepo.createData(employeeDto) == 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Can not insert data");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Insert data successfully");
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Employee employee = employeeRepo.findById(id);
        if(employee == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not exists employee with id = " + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employee);
    }

    @Override
    public ResponseEntity<?> getEmployeeDetail(Long id) {
        EmployDepartDto employDepartDto = employeeRepo.getEmployeeDetail(id);
        if(employDepartDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Can't found employee with id = " + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employDepartDto);
    }

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeRepo.findALL());
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        if(employeeRepo.findById(id) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Can't found employee with id = " + id);
        employeeRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Delete employee success with id = " + id);
    }

    @Override
    public ResponseEntity<?> updateById(Long id, EmployeeDto employeeDto) {
        employeeDto.setEmployee_id(id);
        if(employeeRepo.findById(id) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not exists with id = " + id);
        else if(employeeRepo.updateById(employeeDto) == 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Error, try again");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Update employee with id = " + id);
    }
}
