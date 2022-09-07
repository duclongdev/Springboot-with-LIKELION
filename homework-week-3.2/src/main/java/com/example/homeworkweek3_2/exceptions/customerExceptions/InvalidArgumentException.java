package com.example.homeworkweek3_2.exceptions.customerExceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;
@Getter
public class InvalidArgumentException extends RuntimeException{
    private BindingResult bindingResult;
    public InvalidArgumentException(BindingResult bindingResult){
        this.bindingResult = bindingResult;
    }
}
