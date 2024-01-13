package com.brunojcamargo.crudspring.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        String errorMessage = "Ocorreu um erro inesperado: " + ex.getMessage();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMap.put("error", "Erro interno do servidor");
        responseMap.put("message", errorMessage);

        return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
