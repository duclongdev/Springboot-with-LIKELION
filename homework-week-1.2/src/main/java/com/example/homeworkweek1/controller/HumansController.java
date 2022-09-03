package com.example.homeworkweek1.controller;

import com.example.homeworkweek1.models.Human;
import com.example.homeworkweek1.models.ResponseObject;
import com.example.homeworkweek1.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HumansController {
    @Autowired
    private HumanService humanService;

    @GetMapping("/getAll")
    public String showHumanList(Model model) {
        model.addAttribute("human", humanService.getHumans());
        return "ShowHumans";
    }

    @GetMapping("/getAge15")
    public ResponseEntity<?> getAge15() {
        return humanService.getHumansWhereAge15();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ResponseObject> ListHuman(@PathVariable Long id) {
        return humanService.GetHumanById(id);
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<ResponseObject> AddHuman(@RequestBody Human human) {
        return humanService.addHuman(human);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ResponseObject> UpdateData(@RequestBody Human curHuman, @PathVariable Long id) {
        return humanService.update(curHuman, id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ResponseObject> DeleteHuman(@PathVariable Long id) {
        return humanService.deleteHuman(id);
    }
}
