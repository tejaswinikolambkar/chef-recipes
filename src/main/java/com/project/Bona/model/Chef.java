package com.project.Bona.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chefId;
    @Column(length = 40)
    private String chefName;
    @Column(length = 40)
    private String chefEmail;
    @Column(length = 40)
    private String chefPassword;
    @Column(length = 10)
    private String chefPhone;
    @Column(length = 50)
    private String chefAddress;
    @Column(length = 20)
    private String chefCity;
    @Column(length = 20)
    private String foodType;


}
