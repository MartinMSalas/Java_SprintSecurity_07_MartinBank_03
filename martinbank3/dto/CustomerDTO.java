package com.martin.egg.martinbank3.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String email;
    private String pwd;
    private String role;
}
