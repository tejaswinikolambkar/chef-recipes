package com.project.Bona.service;

import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class AddressService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public List<Address> deleteAddress(String customerAddress){
        return addressRepository.deleteByName(customerAddress);
    }

    public List<Address> showAdd(int customerId){
        return addressRepository.getAddress(customerId);
    }


    public List<Address> showAddress(int customerId){
        return addressRepository.getAddress(customerId);
    }


}
