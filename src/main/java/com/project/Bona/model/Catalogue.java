package com.project.Bona.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Catalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogueId;
    @Column(length = 40)
    private String catalogueName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_id", referencedColumnName = "chefId")
    @JsonIgnore
    private Chef chef;



}
