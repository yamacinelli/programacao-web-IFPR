package com.dev.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseErrorDto {

    private String errorRequest;

    private String errorInObject;

    private List<ErrorDto> errorDtos;
}
