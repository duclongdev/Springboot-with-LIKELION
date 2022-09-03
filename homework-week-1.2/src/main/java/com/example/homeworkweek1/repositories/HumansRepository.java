package com.example.homeworkweek1.repositories;

import com.example.homeworkweek1.models.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumansRepository extends JpaRepository<Human, Long> {
    @Query(value = "SELECT * FROM Human u WHERE u.age = 15", nativeQuery = true)
    List<Human> showHumanWhereAge15();
}
