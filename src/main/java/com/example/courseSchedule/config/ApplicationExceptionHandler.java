package com.example.courseSchedule.config;

import com.example.courseSchedule.api.dto.ErrorResponseDto;
import com.example.courseSchedule.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> dataNotFoundException(DataNotFoundException dataNotFoundException) {
        return new ResponseEntity<>(new ErrorResponseDto(dataNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> defaultException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
