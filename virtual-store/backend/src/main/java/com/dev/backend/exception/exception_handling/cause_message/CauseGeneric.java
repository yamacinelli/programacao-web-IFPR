package com.dev.backend.exception.exception_handling.cause_message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CauseGeneric extends ExceptionHandlingMessage {

    public CauseGeneric() {
        super(null);
    }

    @Override
    public boolean isCause(String cause) {
        return true;
    }

    @Override
    public ResponseEntity<?> causeMessage() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Action is not possible, there was a violation in data.");
    }
}
