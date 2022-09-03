package com.example.homeworkweek1.services.impl;

import com.example.homeworkweek1.models.ResponseObject;
import com.example.homeworkweek1.repositories.HumansRepository;
import com.example.homeworkweek1.models.Human;
import com.example.homeworkweek1.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanImpl implements HumanService {
    @Autowired
    private HumansRepository humansRepository;

    @Override
    public List<Human> getHumans() {
        return humansRepository.findAll(Sort.by(Sort.Direction.ASC, "age"));
    }

    @Override
    public ResponseEntity<ResponseObject> GetHumanById(Long id) {

        Optional<Human> human = humansRepository.findById(id);
        if (human.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Data not exists", ""));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Show data successfully", human));
    }

    @Override
    public ResponseEntity<ResponseObject> getHumansWhereAge15() {
        List<Human> humans = humansRepository.showHumanWhereAge15();
        if (humans.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("Ok", "Show data successfully", humans));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("Failed", "Data not found", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> addHuman(Human human) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("Ok", "Save data successfully", humansRepository.save(human)));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteHuman(Long id) {
        boolean check = humansRepository.existsById(id);
        if (check) {
            humansRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("OK", "Delete data successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("OK", "Cannot found product to delete", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> update(Human curHuman, Long id) {
        Human tempHuman = humansRepository.findById(id).map(human -> {
            human.setName(curHuman.getName());
            human.setAge(curHuman.getAge());
            human.setFavorite(curHuman.getFavorite());
            return humansRepository.save(human);
        }).orElseGet(() -> humansRepository.save(curHuman));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update product successfully", humansRepository.save(tempHuman)));
    }
}
