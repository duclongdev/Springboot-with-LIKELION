package com.example.homeworkweek3_2.controlers;

import com.example.homeworkweek3_2.payload.dto.DepartmentDto;
import com.example.homeworkweek3_2.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/dep")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("test-valid")
    public ResponseEntity<?> checkInvalid(@RequestBody @Valid DepartmentDto departmentDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Department valid");
    }
    @PostMapping("get-dep-dto")
    public ResponseEntity<?> getDepartmentDto(@RequestBody @Valid DepartmentDto departmentDto)
    {
        return departmentService.getDepartmentDto(departmentDto);
    }

}
