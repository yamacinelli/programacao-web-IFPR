package com.dev.backend.exception.rest_exception_handling;

import com.dev.backend.dto.ErrorDto;
import com.dev.backend.dto.ResponseErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandling extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(responseError(e, status), status);
    }

    private ResponseErrorDto responseError(MethodArgumentNotValidException e, HttpStatus status) {
        return new ResponseErrorDto(status.value(), status.getReasonPhrase(), e.getBindingResult().getObjectName(), errorDtos(e));
    }

    private List<ErrorDto> errorDtos(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors()
                .stream()
                .map(obj -> new ErrorDto(obj.getDefaultMessage(), obj.getField(), obj.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
