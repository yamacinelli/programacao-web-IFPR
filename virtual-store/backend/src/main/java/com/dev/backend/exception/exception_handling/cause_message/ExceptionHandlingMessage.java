package com.dev.backend.exception.exception_handling.cause_message;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public abstract class ExceptionHandlingMessage {

    ExceptionHandlingMessage nextMessage;

    public abstract ResponseEntity<?> message(String cause);
}
