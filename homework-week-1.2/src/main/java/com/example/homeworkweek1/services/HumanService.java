package com.example.homeworkweek1.services;

import com.example.homeworkweek1.models.Human;
import com.example.homeworkweek1.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HumanService {
    List<Human> getHumans();

    ResponseEntity<ResponseObject> GetHumanById(Long id);

    ResponseEntity<ResponseObject> getHumansWhereAge15();

    ResponseEntity<ResponseObject> addHuman(Human human);

    ResponseEntity<ResponseObject> deleteHuman(Long id);

    ResponseEntity<ResponseObject> update(Human human, Long id);

}
