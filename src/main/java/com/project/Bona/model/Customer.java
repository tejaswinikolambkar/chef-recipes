package com.project.Bona.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(length = 40)
    private String customerEmail;
    @Column(length = 40)
    private String  customerName;
    @Column(length = 40)
    private String customerPassword;
    @Column(length = 10)
    private String customerPhone;
    @Column(length = 30)
    private String city;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    @JsonIgnore
    private List<Address> addresses=new ArrayList<Address>();

}
