package com.project.Bona.service;
import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private CatalogueRepository catalogueRepository;
    @Autowired
    private RecipeRepository recipeRepository;


    public Chef saveChef(Chef chef){
        return chefRepository.save(chef);
    }

    public List<Chef> getChef(){
        return chefRepository.findAll();
    }

    public Chef findByEmail(String chefEmail) {
        return chefRepository.findByEmail(chefEmail);
    }

    public Optional<Chef> findChefById(int chefId) {
        return chefRepository.findById(chefId);
    }


    public String findByCity(String chefCity){
        return chefRepository.findByCityName(chefCity);
    }

}
