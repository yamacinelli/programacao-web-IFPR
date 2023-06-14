package com.dev.backend.dto;

import lombok.Data;

@Data
public class ErrorDto {

    private String errorMessage;

    private String errorField;

    private Object sent;
}
