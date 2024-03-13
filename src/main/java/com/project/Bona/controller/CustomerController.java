package com.project.Bona.controller;

import com.project.Bona.RuntimeException.*;
import com.project.Bona.dto.*;
import com.project.Bona.model.Customer;
import com.project.Bona.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /* Registration Method */
    @PostMapping("/registerCustomer")
    public RegisterStatus register(@RequestBody Customer customer){
        try{
            customerService.register(customer);
            RegisterStatus status=new RegisterStatus();
            status.setStatus(Status.StatusType.SUCCESS);
            status.setMessage("Registration Successful!");
            return status;
        }
        catch (CustomerServiceException e){
            RegisterStatus status=new RegisterStatus();
            status.setStatus(Status.StatusType.FAILURE);
            status.setMessage(e.getMessage());
            return status;
        }
    }

    /* Login Method */
    @PostMapping("/authCustomer")
    public String getCustomer(@RequestBody Customer customer){
        Customer db=customerService.findByEmail(customer.getCustomerEmail());
        if(db!=null && customer.getCustomerEmail().equals(db.getCustomerEmail())){
            if( customer.getCustomerPassword().equals(db.getCustomerPassword())){

                return "Login Successfully";
            }
            else
                return "Invalid password";
        }
        else
            return "Customer has not registered";
    }

    public int getCustomerByEmail(String customerEmail){
         Customer db=customerService.findByEmail(customerEmail);
         return db.getCustomerId();
    }





}
