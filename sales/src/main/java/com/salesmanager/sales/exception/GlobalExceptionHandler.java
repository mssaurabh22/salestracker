package com.salesmanager.sales.exception;

import com.salesmanager.sales.Models.GenericeResponse;
import com.salesmanager.sales.entity.UserEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Extract information from the exception if needed
        String errorMessage = "Data integrity violation: " + ex.getLocalizedMessage() + " || " + ex.getCause().getMessage();

        // Provide an appropriate HTTP status code and response message
        GenericeResponse response = new GenericeResponse();
        response.setStatus(false);
        response.setErrorMessage(errorMessage);
        return new ResponseEntity<Object>(response, HttpStatus.CONFLICT);

    }
}
