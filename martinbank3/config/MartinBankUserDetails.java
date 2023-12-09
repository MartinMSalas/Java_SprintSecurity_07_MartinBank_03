package com.martin.egg.martinbank3.config;

import com.martin.egg.martinbank3.model.Customer;
import com.martin.egg.martinbank3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MartinBankUserDetails implements UserDetailsService {

    CustomerRepository customerRepository;

    @Autowired
    public MartinBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        List<Customer> customer = customerRepository.findByEmail(username);
        if(customer.size() == 0){
            throw new UsernameNotFoundException("User not found");
        }else {
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority( customer.get(0).getRole()));
        }

        return new User(userName, password, authorities);
    }
}
