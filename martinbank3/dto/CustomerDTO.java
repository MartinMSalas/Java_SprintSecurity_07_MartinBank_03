package com.martin.egg.martinbank3.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String name;

    private String email;
    private String mobileNumber;
    private String pwd;
    private String role;
}
