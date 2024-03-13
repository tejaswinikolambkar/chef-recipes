package com.project.Bona.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;


import javax.persistence.*;


@Data
@Entity
public class Address{

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    public Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Column(length = 100)
    private String customerAddress;

}
