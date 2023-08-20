package com.dev.backend.exception.exception_handling.data_integrity_violation;

import com.dev.backend.exception.exception_handling.ExceptionHandlingMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CauseForeignKey extends ExceptionHandlingMessage {

    public CauseForeignKey(ExceptionHandlingMessage nextMessage) {
        super(nextMessage);
    }

    @Override
    public boolean isCause(String cause) {
        return cause.contains("FOREIGN KEY");
    }

    @Override
    public ResponseEntity<?> causeMessage() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Exclusion is not possible, there was a violation of primary key.");
    }
}
