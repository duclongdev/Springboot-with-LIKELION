package com.example.homeworkweek3_2.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String message;
}
