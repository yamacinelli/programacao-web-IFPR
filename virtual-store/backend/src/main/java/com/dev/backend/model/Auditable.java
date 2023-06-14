package com.dev.backend.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class Auditable {

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date editedDate;
}
