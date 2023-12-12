package com.martin.egg.martinbank3.service;

import com.martin.egg.martinbank3.dto.CustomerDTO;
import com.martin.egg.martinbank3.mapper.CustomerMapper;
import com.martin.egg.martinbank3.model.Customer;
import com.martin.egg.martinbank3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, PasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public CustomerDTO save(CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setPwd(bCryptPasswordEncoder.encode(customer.getPwd()));

        Customer customerSaved = customerRepository.save(customer);
        CustomerDTO customerDTOSaved = customerMapper.customerToCustomerDTO(customerSaved);

        return customerDTOSaved;
    }

}
