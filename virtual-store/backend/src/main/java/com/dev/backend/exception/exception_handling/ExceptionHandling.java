package com.dev.backend.exception.exception_handling;

import com.dev.backend.exception.exception_handling.cause_message.CauseForeignKey;
import com.dev.backend.exception.exception_handling.cause_message.CauseGeneric;
import com.dev.backend.exception.exception_handling.cause_message.CausePrimaryKey;
import com.dev.backend.exception.exception_handling.cause_message.ExceptionHandlingMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handlerDataIntegrityViolation(DataIntegrityViolationException e) {
        ExceptionHandlingMessage exceptionHandlingMessage = new CausePrimaryKey(new CauseForeignKey(new CauseGeneric()));
        return exceptionHandlingMessage.message(e.getMostSpecificCause().toString());
    }
}
