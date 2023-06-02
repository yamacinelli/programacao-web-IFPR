package com.dev.backend.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class Auditable {

    private Date createdDate;

    private Date editedDate;
}
