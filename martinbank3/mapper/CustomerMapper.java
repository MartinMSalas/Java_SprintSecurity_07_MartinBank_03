package com.martin.egg.martinbank3.mapper;

import com.martin.egg.martinbank3.dto.CustomerDTO;
import com.martin.egg.martinbank3.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    public Customer customerDTOToCustomer(CustomerDTO customerDTO);
    public CustomerDTO customerToCustomerDTO(Customer customer);
}
