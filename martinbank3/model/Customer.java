package com.martin.egg.martinbank3.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;
    private String email;
    private String pwd;
    private String role;


}
