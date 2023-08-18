package com.dev.backend.exception.exception_handling.cause_message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CauseForeignKey extends ExceptionHandlingMessage {

    public CauseForeignKey(ExceptionHandlingMessage nextMessage) {
        super(nextMessage);
    }

    @Override
    public ResponseEntity<?> message(String cause) {
        if (cause.contains("FOREIGN KEY")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Exclusion is not possible, there was a violation of primary key.");
        }
        return nextMessage.message(cause);
    }
}
