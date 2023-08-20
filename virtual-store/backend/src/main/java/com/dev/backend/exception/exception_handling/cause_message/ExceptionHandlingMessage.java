package com.dev.backend.exception.exception_handling.cause_message;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public abstract class ExceptionHandlingMessage {

    ExceptionHandlingMessage nextMessage;

    public ResponseEntity<?> message(String cause) {
        if (isCause(cause)) {
            return this.causeMessage();
        }
        return nextMessage.message(cause);
    }

    abstract boolean isCause(String cause);

    abstract ResponseEntity<?> causeMessage();
}
