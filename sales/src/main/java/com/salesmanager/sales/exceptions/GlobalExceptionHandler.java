package com.salesmanager.sales.exceptions;

import com.salesmanager.sales.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse("Something went wrong", ex.getMessage());

        // Return a ResponseEntity with the custom error response and an appropriate HTTP status code
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
