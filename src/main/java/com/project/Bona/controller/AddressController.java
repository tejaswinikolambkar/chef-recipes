package com.project.Bona.controller;

import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import com.project.Bona.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping("/getAddress")
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @DeleteMapping("/deleteAddress/{customerAddress}")
    public List<Address> removeAddress(@PathVariable String customerAddress){
        return addressService.deleteAddress(customerAddress);
    }

    @GetMapping("/getAdd/{customerId}")
    List<Address> getAdd(@PathVariable int customerId){
        return addressService.showAdd(customerId);
    }

    @GetMapping("/getAddress/{customerEmail}")
    List<Address> getAddress(@PathVariable String customerEmail){
        int customerId=customerController.getCustomerByEmail(customerEmail);
        return addressService.showAdd(customerId);
    }
}
