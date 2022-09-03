package com.example.homeworkwithlikelionw2_1.repository;

import com.example.homeworkwithlikelionw2_1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
