package com.dev.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AuditableDto {

    private Date createdDate;

    private Date editedDate;
}
