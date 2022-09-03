package com.homework.homework_with_likelion_w2_2.designPattern.controller;

import com.homework.homework_with_likelion_w2_2.designPattern.computer.Computer;
import com.homework.homework_with_likelion_w2_2.designPattern.factory.ComputerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factory-method")
public class DPController {

    @Autowired
    ComputerFactory computerFactory;
    @GetMapping("/{type}")
    public String getMethod(@PathVariable String type){
        System.out.println("Factory DesignPattern: ");
        Computer computer = computerFactory.getComputer(type);
        System.out.println("Type: " + type);
        System.out.println("Computer: " + computer.getType());
        System.out.println("Singleton DesignPattern: " + computerFactory);
        return computer.getType();
    }
}
