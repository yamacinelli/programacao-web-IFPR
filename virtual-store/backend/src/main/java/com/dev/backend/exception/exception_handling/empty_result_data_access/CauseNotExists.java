package com.dev.backend.exception.exception_handling.empty_result_data_access;

import com.dev.backend.exception.exception_handling.ExceptionHandlingMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CauseNotExists extends ExceptionHandlingMessage {

    public CauseNotExists() {
        super(null);
    }

    @Override
    protected boolean isCause(String cause) {
        return true;
    }

    @Override
    public ResponseEntity<?> causeMessage() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Exclusion is not possible, object does not exists.");
    }
}
