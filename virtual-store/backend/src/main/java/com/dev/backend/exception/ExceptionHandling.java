package com.dev.backend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handlerDataIntegrityViolation(DataIntegrityViolationException e) {
        if (e.getMostSpecificCause().toString().contains("FOREIGN KEY")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Exclusion is not possible, there was a violation of foreign key.");
        } else if (e.getMostSpecificCause().toString().contains("PRIMARY KEY")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Exclusion is not possible, there was a violation of primary key.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Action is not possible, there was a violation in data.");
        }
    }
}
