package com.dev.backend.exception.exception_handling;

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

    protected abstract boolean isCause(String cause);

    public abstract ResponseEntity<?> causeMessage();
}
