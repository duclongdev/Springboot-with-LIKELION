package com.example.homeworkwithlikelionw2_1.repository;

import com.example.homeworkwithlikelionw2_1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findDepartmentsByDepName(String depName);
}
