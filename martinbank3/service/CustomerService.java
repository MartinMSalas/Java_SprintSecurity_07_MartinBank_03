package com.martin.egg.martinbank3.service;

import com.martin.egg.martinbank3.dto.CustomerDTO;
import com.martin.egg.martinbank3.mapper.CustomerMapper;
import com.martin.egg.martinbank3.model.Customer;
import com.martin.egg.martinbank3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO save(CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);


        Customer customerSaved = customerRepository.save(customer);
        CustomerDTO customerDTOSaved = customerMapper.customerToCustomerDTO(customerSaved);

        return customerDTOSaved;
    }

}
