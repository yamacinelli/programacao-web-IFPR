package yamacinelli.core.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table
@Entity
@Data
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String repositoryOwner;

    private String repositoryName;

    private String repositoryLink;

    private Integer count;

    private String message;
}
