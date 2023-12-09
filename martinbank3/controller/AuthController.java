package com.martin.egg.martinbank3.controller;

import com.martin.egg.martinbank3.dto.CustomerDTO;
import com.martin.egg.martinbank3.repository.CustomerRepository;
import com.martin.egg.martinbank3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    CustomerRepository customerRepository;
    CustomerService customerService;

    @Autowired
    public AuthController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CustomerDTO customerDTO){
        CustomerDTO savedCustomerDTO;
        ResponseEntity<?> response = null;
        try{
            savedCustomerDTO = customerService.save(customerDTO);
            if(savedCustomerDTO.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedCustomerDTO);
            }
        }catch (Exception e){
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering user");
        }
        return response;

    }
}
