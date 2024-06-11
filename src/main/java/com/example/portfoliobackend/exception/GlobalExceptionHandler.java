package com.example.portfoliobackend.exception;


import com.example.portfoliobackend.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//        StringBuilder errorMessages = new StringBuilder();
//
//        List<ObjectError> result =  exception.getBindingResult().getAllErrors();
//        for (ObjectError o : result) {
//            String currentErrorMessage = o.getDefaultMessage();
//            errorMessages.append(currentErrorMessage).append(", ");
//        }
//        ResponseDTO errorResponse = ResponseDTO.builder().hasError(true).error(String.valueOf(errorMessages)).message(String.valueOf(errorMessages)).status(HttpStatus.BAD_REQUEST).build();
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleRuntimeException(RuntimeException exception) {
        ResponseDTO errorResponse = ResponseDTO.builder().hasError(true).error(exception.getMessage()).message(exception.getMessage()).status(HttpStatus.BAD_REQUEST).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception exception) {
        ResponseDTO errorResponse = ResponseDTO.builder().hasError(true).error("Something went wrong").message("Something went wrong").status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}