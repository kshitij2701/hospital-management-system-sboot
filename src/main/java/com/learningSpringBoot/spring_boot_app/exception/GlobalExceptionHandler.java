package com.learningSpringBoot.spring_boot_app.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        "RESOURCE_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(
                        "INTERNAL_ERROR",
                        "Something went wrong"
                ));
    }
}
