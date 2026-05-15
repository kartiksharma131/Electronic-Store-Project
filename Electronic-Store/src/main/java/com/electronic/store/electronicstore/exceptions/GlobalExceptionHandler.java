package com.electronic.store.electronicstore.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }


    @ExceptionHandler(BadApiException.class)
    public ResponseEntity<String> BadApiExceptionHandler(BadApiException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    //MethodArgumentNotValidException

    public ResponseEntity<Map<String,Object>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Validation failed");
        response.put("errors",ex.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList()));
        return ResponseEntity.status(400).body(response);
    }
}
