package com.project.Bona.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    @Column(length = 40)
    private String recipeName;
    private double recipePrice;
    @Column(length = 20)
    private String foodType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_id", referencedColumnName = "chefId")
    private Chef chef;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogue_id", referencedColumnName = "catalogueId")
    private Catalogue catalogue;


}
