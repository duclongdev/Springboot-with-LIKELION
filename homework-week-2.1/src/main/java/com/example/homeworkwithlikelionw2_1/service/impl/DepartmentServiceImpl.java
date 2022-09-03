package com.example.homeworkwithlikelionw2_1.service.impl;

import com.example.homeworkwithlikelionw2_1.model.Department;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import com.example.homeworkwithlikelionw2_1.repository.DepartmentRepo;
import com.example.homeworkwithlikelionw2_1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public ResponseEntity<ResponseObject> insertData(Department department) {
        if(departmentRepo.findDepartmentsByDepName(department.getDepName()).size() > 0)
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new ResponseObject("Failed", "Name has been taken", ""));
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("Ok", "Insert data successfully", departmentRepo.save(department)));


    }
    @Override
    public ResponseEntity<ResponseObject> getAll() {
        List<Department> departments = departmentRepo.findAll();
        if(departments.size() > 0)
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ResponseObject("Ok", "Show all data successfully", departmentRepo.findAll()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Ok", "No thing to show", departmentRepo.findAll()));
    }

    @Override
    public ResponseEntity<ResponseObject> getDepById(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if(!department.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new ResponseObject("Failed", "Department not exists", ""));

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("OK", "Show data successfully", department.get()));
    }

    @Override
    public ResponseEntity<ResponseObject> updateDep(Long id, Department CurDepartment) {
        Optional<Department> department = departmentRepo.findById(id);
        if(department.isPresent())
        {
            department.map(tempDepartment ->{
                tempDepartment.setId(id);
                tempDepartment.setDepName(CurDepartment.getDepName());
                tempDepartment.setEmployees(CurDepartment.getEmployees());
                tempDepartment.setDescription(CurDepartment.getDescription());
            return departmentRepo.save(tempDepartment);
        }).orElseGet(()->{
            return departmentRepo.save(CurDepartment);
        });
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("OK", "update data successfully", ""));
        }
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Department not exits", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteDep(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if(department.isPresent() && department.get().getEmployees().size() > 0)
        {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
                    .body(new ResponseObject("Failed", "Can't delete because the employee exists", ""));
        }else if(department.isPresent()){
            departmentRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("OK", "Delete successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Department not exits", ""));
    }
}
