package com.dev.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {

    private String errorMessage;

    private String errorField;

    private Object sent;
}
