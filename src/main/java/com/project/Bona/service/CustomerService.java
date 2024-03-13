package com.project.Bona.service;

import com.project.Bona.RuntimeException.*;
import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    /* Customer Registration */
    public void register(Customer customer) {
        customerRepository.save(customer);
    }

    /* Login Customer */
    public Customer findByEmail(String customerEmail){
       return customerRepository.findByEmail(customerEmail);
    }

    /* It will return list of all the registered customer */
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

}

