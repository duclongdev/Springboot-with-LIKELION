package com.example.homeworkweek3_2.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class ResponseObject {
    private HttpStatus httpStatus;
    private String message;
    private Object data;
}
