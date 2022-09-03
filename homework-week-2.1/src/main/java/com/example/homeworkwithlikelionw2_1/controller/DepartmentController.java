package com.example.homeworkwithlikelionw2_1.controller;


import com.example.homeworkwithlikelionw2_1.model.Department;
import com.example.homeworkwithlikelionw2_1.model.ResponseObject;
import com.example.homeworkwithlikelionw2_1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseObject> getAll()
    {
        return departmentService.getAll();
    }

    @GetMapping("/getDepById/{id}")
    public ResponseEntity<ResponseObject> getDepById(@PathVariable Long id)
    {
        return departmentService.getDepById(id);
    }


    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertData(@RequestBody Department department){
        return departmentService.insertData(department);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateData(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDep(id, department);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteData(@PathVariable Long id)
    {
        return departmentService.deleteDep(id);
    }

}
