package com.dev.backend.exception;

import com.dev.backend.exception.exception_handling.data_integrity_violation.CauseForeignKey;
import com.dev.backend.exception.exception_handling.data_integrity_violation.CauseGeneric;
import com.dev.backend.exception.exception_handling.data_integrity_violation.CausePrimaryKey;
import com.dev.backend.exception.exception_handling.ExceptionHandlingMessage;
import com.dev.backend.exception.exception_handling.empty_result_data_access.CauseNotExists;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handlerEmptyResultDataAccess(EmptyResultDataAccessException e) {
        ExceptionHandlingMessage exceptionHandlingMessage = new CauseNotExists();
        return exceptionHandlingMessage.message(e.getMostSpecificCause().toString());
    }
}
