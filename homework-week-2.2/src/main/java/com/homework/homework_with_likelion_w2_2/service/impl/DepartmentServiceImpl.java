package com.homework.homework_with_likelion_w2_2.service.impl;

import com.homework.homework_with_likelion_w2_2.entity.Department;
import com.homework.homework_with_likelion_w2_2.entity.Employee;
import com.homework.homework_with_likelion_w2_2.payload.dto.DepartmentDto;
import com.homework.homework_with_likelion_w2_2.repository.DepartmentRepo;
import com.homework.homework_with_likelion_w2_2.repository.EmployeeRepo;
import com.homework.homework_with_likelion_w2_2.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentRepo departmentRepo;
    @Resource
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<?> createData(Department department) {
        int result = departmentRepo.createData(department);
        if(result == 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Insert data unsuccessfully");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Insert data successfully");
    }
    @Override
    public ResponseEntity<?> findById(Long id) {
        Department department = departmentRepo.findById(id);
        if(department == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department with id not be found");
        List<Employee> employees = employeeRepo.findByDeptId(id);
        department.setEmployees(employees);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }
    @Override
    public ResponseEntity<?> findByIdIncludeEmployeeQuantity(Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(departmentRepo.countEmployForEachDep(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exists by ID = " + id);
        }
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        if(departmentRepo.countEmployeeByDeptId(id) > 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Cannot delete because the employee is existing");
        if(departmentRepo.findById(id) != null) {
            departmentRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("delete department successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not found department with id: " + id);
    }
    @Override
    public ResponseEntity<?> updateById(Long id, Department department) {
        department.setDepartment_id(id);
        if(departmentRepo.findById(id) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department not exists");
        else if(departmentRepo.updateByID(department) == 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Error, try again");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Update department successfully");
    }

}
